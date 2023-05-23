package MilkStgo.Pep1;

import MilkStgo.Pep1.Entities.PlanillaEntity;
import MilkStgo.Pep1.Entities.PorcentajeEntity;
import MilkStgo.Pep1.Entities.ProveedorEntity;
import MilkStgo.Pep1.Repositories.AcopioRepository;
import MilkStgo.Pep1.Repositories.PlanillaRepository;
import MilkStgo.Pep1.Repositories.PorcentajeRepository;
import MilkStgo.Pep1.Repositories.ProveedorRepository;
import MilkStgo.Pep1.Services.*;
import MilkStgo.Pep1.Entities.AcopioEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;



@SpringBootTest

public class PagoFinalServiceTests {
    @Autowired
    private PagoFinalService pagoFinalService;

    @Autowired
    private AcopioRepository acopioRepository;

    @Autowired
    private AcopioService acopioService;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private PorcentajeService porcentajeService;

    @Autowired
    private PorcentajeRepository porcentajeRepository;

    @Autowired
    private PlanillaService planillaService;






    @Test
    public void contextLoads() {
    }

    //Con solido=3 y kilos=10, la salida debe ser -1300
    @Test
    public void testPagoPorcentajeSolido(){
        int resultado= pagoFinalService.pagoPorcentajeSolido(3,10);
        assertEquals(-1300,resultado);
    }

    //Con solido=12 y kilos 5, la salida debe ser -450
    @Test
    public void testPagoPorcentajeSolido2(){
        int resultado= pagoFinalService.pagoPorcentajeSolido(12,5);
        assertEquals(-450,resultado);
    }

    //Con solido=24 y kilos 10, la salida debe ser 950
    @Test
    public void testPagoPorcentajeSolido3(){
        int resultado= pagoFinalService.pagoPorcentajeSolido(24,10);
        assertEquals(950,resultado);
    }

    //Con solido=40 y kilos=10, la salida debe ser 1500
    @Test
    public void testPagoPorcentajeSolido4(){
        int resultado= pagoFinalService.pagoPorcentajeSolido(40,10);
        assertEquals(1500,resultado);
    }

    //Con solido=-1 y kilos=10, la salida debe ser 0
    @Test
    public void testPagoPorcentajeSolido5(){
        int resultado= pagoFinalService.pagoPorcentajeSolido(-1,10);
        assertEquals(0,resultado);
    }

    //Con grasa= 10 y kilos=10, la salida debe ser 300
    @Test
    public void testPagoPorcentajeGrasa(){
        int resultado= pagoFinalService.pagoPorcentajeGrasa(10,10);
        assertEquals(300,resultado);
    }

    //con grasa=30 y kilos=10, la salida debe ser 800
    @Test
public void testPagoPorcentajeGrasa2(){
        int resultado= pagoFinalService.pagoPorcentajeGrasa(30,10);
        assertEquals(800,resultado);
    }

    //con grasa=50 y kilos=10, la salida debe ser 1200
    @Test
    public void testPagoPorcentajeGrasa3(){
        int resultado= pagoFinalService.pagoPorcentajeGrasa(50,10);
        assertEquals(1200,resultado);
    }

    //con grasa=-1 y kilos=10, la salida debe ser 0
    @Test
    public void testPagoPorcentajeGrasa4(){
        int resultado= pagoFinalService.pagoPorcentajeGrasa(-1,10);
        assertEquals(0,resultado);
    }

    //con categoria="A" y kilos=10, la salida debe ser 7000
    @Test
    public void testPagoCategoria(){
        int resultado= pagoFinalService.pagoCategoria("A",10);
        assertEquals(7000,resultado);
    }

    //con categoria="B" y kilos=10, la salida debe ser 5500
    @Test
    public void testPagoCategoria2(){
        int resultado= pagoFinalService.pagoCategoria("B",10);
        assertEquals(5500,resultado);
    }

    //con categoria="C" y kilos=10, la salida debe ser 4000
    @Test
    public void testPagoCategoria3(){
        int resultado= pagoFinalService.pagoCategoria("C",10);
        assertEquals(4000,resultado);
    }

    //con categoria="D" y kilos=10, la salida debe ser 2500
    @Test
    public void testPagoCategoria4(){
        int resultado= pagoFinalService.pagoCategoria("D",10);
        assertEquals(2500,resultado);
    }
    //con categoria="E" y kilos=10, la salida debe ser 0
    @Test
    public void testPagoCategoria5(){
        int resultado= pagoFinalService.pagoCategoria("E",10);
        assertEquals(0,resultado);
    }

    //con diferenciaKilos=5 , la salida debe ser 0
    @Test
    public void testVariacionKilos(){
        int resultado= pagoFinalService.variacionKilos(5);
        assertEquals(0,resultado);
    }

    //con diferenciaKilos=10 , la salida debe ser 7
    @Test
    public void testVariacionKilos2(){
        int resultado= pagoFinalService.variacionKilos(10);
        assertEquals(7,resultado);
    }

    //con diferenciaKilos=30 , la salida debe ser 15
    @Test
    public void testVariacionKilos3(){
        int resultado= pagoFinalService.variacionKilos(30);
        assertEquals(15,resultado);
    }

    //con diferenciaKilos=50 , la salida debe ser 30
    @Test
    public void testVariacionKilos4(){
        int resultado= pagoFinalService.variacionKilos(50);
        assertEquals(30,resultado);
    }

    //con diferenciaKilos=-1, la salida debe ser -1
    @Test
    public void testVariacionKilos5(){
        int resultado= pagoFinalService.variacionKilos(-1);
        assertEquals(-1,resultado);
    }

    //con diferenciaGrasa=5, la salida debe ser 0
    @Test
    public void testVariacionGrasa(){
        int resultado= pagoFinalService.variacionGrasa(5);
        assertEquals(0,resultado);
    }

    //con diferenciaGrasa=20, la salida debe ser 12
    @Test
    public void testVariacionGrasa2(){
        int resultado= pagoFinalService.variacionGrasa(20);
        assertEquals(12,resultado);
    }

    //con diferenciaGrasa=30, la salida debe ser 20
    @Test
    public void testVariacionGrasa3(){
        int resultado= pagoFinalService.variacionGrasa(30);
        assertEquals(20,resultado);
    }

    //con diferenciaGrasa=50, la salida debe ser 30
    @Test
    public void testVariacionGrasa4(){
        int resultado= pagoFinalService.variacionGrasa(50);
        assertEquals(30,resultado);
    }

    //con diferenciaGrasa=-1, la salida debe ser -1
    @Test
    public void testVariacionGrasa5(){
        int resultado= pagoFinalService.variacionGrasa(-1);
        assertEquals(-1,resultado);
    }

    //con diferenciaSolido=5, la salida debe ser 0
    @Test
    public void testVariacionSolido(){
        int resultado= pagoFinalService.variacionSolido(5);
        assertEquals(0,resultado);
    }

    //con diferenciaSolido=10, la salida debe ser 18
    @Test
    public void testVariacionSolido2(){
        int resultado= pagoFinalService.variacionSolido(10);
        assertEquals(18,resultado);
    }

    //con diferenciaSolido=20, la salida debe ser 27
    @Test
    public void testVariacionSolido3(){
        int resultado= pagoFinalService.variacionSolido(20);
        assertEquals(27,resultado);
    }

    //con diferenciaSolido=40, la salida debe ser 45
    @Test
    public void testVariacionSolido4(){
        int resultado= pagoFinalService.variacionSolido(40);
        assertEquals(45,resultado);
    }

    //con diferenciaSolido=-1, la salida debe ser -1
    @Test
    public void testVariacionSolido5(){
        int resultado= pagoFinalService.variacionSolido(-1);
        assertEquals(-1,resultado);
    }

    //con pagoAcopio= 100, manana=false y tarde =true la salida debe ser 8
    @Test
    public void testPagoFrecuencia(){
        double resultado= pagoFinalService.pagoFrecuencia(100,false,true);
        assertEquals(8,resultado);
    }

    //con pagoAcopio=150, manana=true y tarde=true la salida deber ser 30
    @Test
    public void testPagoFrecuencia2(){
        double resultado= pagoFinalService.pagoFrecuencia(150,true,true);
        assertEquals(30,resultado);
    }

    //con pagoAcopio=200, manana=true y tarde=false la salida deber ser 24
    @Test
    public void testPagoFrecuencia3(){
        double resultado= pagoFinalService.pagoFrecuencia(200,true,false);
        assertEquals(24,resultado);
    }

    //con pagoAcopio=200, manana=false y tarde=false la salida deber ser 16
    @Test
    public void testPagoFrecuencia4(){
        double resultado= pagoFinalService.pagoFrecuencia(200,false,false);
        assertEquals(16,resultado);
    }

    //Con ArrayList de entrada con 4 días diferentes, la salida debe ser 4
    @Test
    public void testObtenerDias(){
        ArrayList<String> fechas = new ArrayList<String>();
        fechas.add("2021-05-01");
        fechas.add("2021-05-02");
        fechas.add("2021-05-03");
        fechas.add("2021-05-04");
        fechas.add("2021-05-02");
        int resultado = Integer.parseInt(pagoFinalService.obtenerDias(fechas));

        assertEquals(4,resultado);
    }

    @Test
    public void testGenerarPlanilla() {
        // Poblando db con datos dummies

        AcopioEntity aux1 = new AcopioEntity();
        aux1.setIDACOPIO(1);
        aux1.setIDarchivo(2);
        aux1.setFecha("17/03/2023");
        aux1.setTurno("M");
        aux1.setProveedor("1003");
        aux1.setKls_leche(50);

        AcopioEntity aux2 = new AcopioEntity();
        aux2.setIDACOPIO(2);
        aux2.setIDarchivo(2);
        aux2.setFecha("17/03/2023");
        aux2.setTurno("T");
        aux2.setProveedor("1003");
        aux2.setKls_leche(50);

        AcopioEntity aux3 = new AcopioEntity();
        aux3.setIDACOPIO(3);
        aux3.setIDarchivo(2);
        aux3.setFecha("16/03/2023");
        aux3.setTurno("M");
        aux3.setProveedor("1000");
        aux3.setKls_leche(50);

        AcopioEntity aux4 = new AcopioEntity();
        aux4.setIDACOPIO(4);
        aux4.setIDarchivo(1);
        aux4.setFecha("31/03/2023");
        aux4.setTurno("M");
        aux4.setProveedor("1000");
        aux4.setKls_leche(50);

        AcopioEntity aux5 = new AcopioEntity();
        aux5.setIDACOPIO(5);
        aux5.setIDarchivo(1);
        aux5.setFecha("31/03/2023");
        aux5.setTurno("M");
        aux5.setProveedor("1003");
        aux5.setKls_leche(25);

        acopioRepository.save(aux1);
        acopioRepository.save(aux2);
        acopioRepository.save(aux3);
        acopioRepository.save(aux4);
        acopioRepository.save(aux5);

        ProveedorEntity proveedor = new ProveedorEntity();
        proveedor.setIDPROVEEDOR(1);
        proveedor.setCodigo("1003");
        proveedor.setNombre("Pepe");
        proveedor.setCategoria("A");
        proveedor.setRetencion(true);

        proveedorRepository.save(proveedor);

        PorcentajeEntity porcentaje = new PorcentajeEntity();
        porcentaje.setID_PORCENTAJE(1);
        porcentaje.setID_archivo(1);
        porcentaje.setCod_proveedor("1003");
        porcentaje.setGrasa(15);
        porcentaje.setSolido(15);
        porcentaje.setFecha("17/03/2023");

        porcentajeRepository.save(porcentaje);

        //################################################################

        PlanillaEntity expected = new PlanillaEntity();
        expected.setID_PLANILLA(1);
        expected.setFecha("2");
        expected.setCodigo("1003");
        expected.setNombre("Pepe");
        expected.setKls_leche("100");
        expected.setDias("1");
        expected.setPromedio_kls("100");
        expected.setVariacion_leche("0.0");
        expected.setGrasa("15");
        expected.setVariacion_grasa("0");
        expected.setSolidos("15");
        expected.setVariacion_solidos("0");
        expected.setPago_leche("70000");
        expected.setPago_grasa("3000");
        expected.setPago_solidos("-9000");
        expected.setBonificacion_frecuencia("0.0");
        expected.setDescuento_variacion_leche("100.0");
        expected.setDescuento_variacion_grasa("0.0");
        expected.setDescuento_variacion_solidos("0.0");
        expected.setPago_total("64000.0");
        expected.setMonto_retencion("0.0");
        expected.setMonto_final("64000.0");

        PlanillaEntity result = pagoFinalService.generarPlanilla("1003");

        assertEquals(expected, result);

        ArrayList<AcopioEntity> acopios = acopioService.obtenerAcopios();
        ArrayList<ProveedorEntity> proveedores = proveedorService.obtenerProveedores();
        ArrayList<PorcentajeEntity> porcentajes = porcentajeService.obtenerPorcentaje();
        ArrayList<PlanillaEntity> planillas = new ArrayList<>();
        PlanillaEntity planilla = planillaService.getAll();
        planillas.add(planilla);
        planillaService.eliminarData(planillas);
        acopioService.eliminarData(acopios);
        proveedorService.eliminarData(proveedores);
        porcentajeService.eliminarData(porcentajes);
    }

}
