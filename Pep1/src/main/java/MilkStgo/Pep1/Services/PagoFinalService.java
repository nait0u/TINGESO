package MilkStgo.Pep1.Services;

import MilkStgo.Pep1.Entities.PlanillaEntity;
import MilkStgo.Pep1.Entities.ProveedorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class PagoFinalService {
    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private AcopioService acopioService;

    @Autowired
    private PorcentajeService porcentajeService;

    @Autowired
    private PlanillaService planillaService;

    public int pagoPorcentajeSolido(int solido, int kilos) {
        if(0 <= solido && solido <= 7) {
            return (-130 * kilos);
        }
        else if(8 <= solido && solido <= 18) {
            return (-90 * kilos);
        }
        else if(19 <= solido && solido <= 35) {
            return (95 * kilos);
        }
        else if (36 <= solido) {
            return (150 * kilos);
        }
        else {
            return 0;
        }
    }

    public int pagoPorcentajeGrasa(int grasa, int kilos){
        if(0 <= grasa && grasa <= 20){
            return (30 * kilos);
        }
        else if(21 <= grasa && grasa <= 45){
            return (80 * kilos);
        }
        else if(46 <= grasa){
            return (120 * kilos);
        }
        else {
            return 0;
        }
    }

    public int pagoCategoria(String categoria, int kilos){
        return switch (categoria) {
            case "A" -> (700 * kilos);
            case "B" -> (550 * kilos);
            case "C" -> (400 * kilos);
            case "D" -> (250 * kilos);
            default -> 0;
        };
    }

    public int variacionKilos(int diferenciaKilos){
        if( 0 <= diferenciaKilos && diferenciaKilos <= 8){
            return 0;
        }
        else if (9 <= diferenciaKilos && diferenciaKilos <= 25){
            return 7;
        }
        else if(26 <= diferenciaKilos && diferenciaKilos <= 45){
            return 15;
        }
        else if(46 <= diferenciaKilos){
            return 30;
        }
        else{
            return -1;
        }

    }

    public int variacionGrasa(int diferenciaGrasa){
        if (0 <= diferenciaGrasa && diferenciaGrasa <= 15){
            return 0;
        }
        else if(16 <= diferenciaGrasa && diferenciaGrasa <= 25){
            return 12;
        }else if(26 <= diferenciaGrasa && diferenciaGrasa <= 40){
            return 20;
        }else if(41 <= diferenciaGrasa){
            return 30;
        }else{
            return -1;
        }
    }

    public int variacionSolido(int diferenciaSolido){
        if(0 <= diferenciaSolido && diferenciaSolido <= 6){
            return 0;
        }
        else if(7 <= diferenciaSolido && diferenciaSolido <= 12){
            return 18;
        }
        else if(13 <= diferenciaSolido && diferenciaSolido <= 35){
            return 27;
        }
        else if(36 <= diferenciaSolido){
            return 45;
        }
        else{
            return -1;
        }
    }

    public String obtenerDias(ArrayList<String> fechas){
        ArrayList<String> dias = new ArrayList<>();
        for (String fecha: fechas){
            System.out.println(fechas);
            String aux= fecha.split("/")[0];
            if(!dias.contains(aux)){
                dias.add(aux);
            }
        }
        return(Integer.toString(dias.size()));
    }

    public double pagoFrecuencia(double pagoAcopio, boolean manana,boolean tarde){
        double pagoFrecuencia=0;
        if (manana && tarde){
            pagoFrecuencia= pagoAcopio*0.2;
        }
        else if (manana){
            pagoFrecuencia= pagoAcopio*0.12;
        }
        else {
            pagoFrecuencia= pagoAcopio*0.08;
        }
        return pagoFrecuencia;
    }

    public PlanillaEntity generarPlanilla(String codigo){
        //obteniendo datos
        ArrayList<String> fechas = acopioService.obtenerFechas(codigo);
        ProveedorEntity proveedor = proveedorService.findByCodigo(codigo);
        ArrayList<String> variacionLeche = acopioService.obtenerVariacionLeche(codigo);
        String nombre= proveedorService.findByCodigo(codigo).getNombre();
        int kilos= acopioService.klsLeche(codigo);
        String dias = obtenerDias(fechas);
        String quincena = "";

        if (Integer.parseInt(fechas.get(0).split("/")[0]) <= 15){
            quincena = "1";
        }
        else{
            quincena = "2";
        }

        //Cálculos varios
        int diferenciaKilos= Integer.parseInt(variacionLeche.get(0));
        String categoria =proveedorService.obtenerCategoria(codigo);
        int grasa =porcentajeService.obtenerGrasa(codigo);
        int solido= porcentajeService.obtenerSolido(codigo);
        ArrayList<Boolean> turnos= acopioService.obtenerTurnos(codigo);
        boolean manana= turnos.get(0);
        boolean tarde= turnos.get(1);
        String diferenciaGrasa= porcentajeService.obtenerDiferenciaGrasa(codigo);
        String diferenciaSolido= porcentajeService.obtenerDiferenciaSolido(codigo);
        System.out.println("12");
        //Cálculos de pagos
        int pagoLeche= pagoCategoria(categoria,kilos);
        int pagoGrasa= pagoPorcentajeGrasa(grasa,kilos);
        int pagoSolido= pagoPorcentajeSolido(solido,kilos);
        double pagoAcopio= pagoLeche+pagoGrasa+pagoSolido;

        double pago_Frecuencia= 0.00 ;
        if(Integer.parseInt(dias) >= 10){
            pago_Frecuencia= pagoFrecuencia(pagoAcopio,manana,tarde);
        }
        pagoAcopio= pagoAcopio+pago_Frecuencia;
        double variacionKls= 0;
        if(diferenciaKilos < 0){
            variacionKls= pagoAcopio*(variacionKilos(Math.abs(diferenciaKilos))/100);
        }
        double variacion_Grasa= pagoAcopio*(variacionGrasa(Integer.parseInt(diferenciaGrasa))/100.0);
        double variacion_Solido= pagoAcopio*(variacionSolido(Integer.parseInt(diferenciaSolido))/100.0);
        double descuentos= variacionKls+variacion_Grasa+variacion_Solido;
        double pagoTotal= pagoAcopio-descuentos;
        double retencion= 0.00;
        if(pagoTotal >= 950000 && proveedor.getRetencion()){
            retencion= pagoTotal*0.13;
        }

        double pagoNeto= pagoTotal-retencion;

        //Creando planilla
        planillaService.guardarPlanilla(quincena,
                codigo,
                nombre,
                Integer.toString(kilos),
                dias,
                Integer.toString(kilos/Integer.parseInt(dias)),
                Double.toString(variacionKls),
                Integer.toString(grasa),
                diferenciaGrasa,
                Integer.toString(solido),
                diferenciaSolido,
                Integer.toString(pagoLeche),
                Integer.toString(pagoGrasa),
                Integer.toString(pagoSolido),
                Double.toString(pago_Frecuencia),
                Double.toString(kilos),
                Double.toString(variacion_Grasa),
                Double.toString(variacion_Solido),
                Double.toString(pagoTotal),
                Double.toString(retencion),
                Double.toString(pagoNeto));

        PlanillaEntity planilla = planillaService.getAll();
        return planilla;






    }




}
