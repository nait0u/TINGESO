package MilkStgo.Pep1.Services;

import MilkStgo.Pep1.Entities.AcopioEntity;
import MilkStgo.Pep1.Repositories.AcopioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AcopioService {
    @Autowired
    AcopioRepository acopioRepository;

    public ArrayList<AcopioEntity> obtenerAcopios(){
        return (ArrayList<AcopioEntity>) acopioRepository.findAll();
    }

    public int klsLeche(String codigo){
        int totalKgs = 0;
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();

        int id = obtenerCantArchivos(acopios);
        ArrayList<Integer> klsLeche = acopioRepository.kgsFiltro(id, codigo);

        for (Integer kg:klsLeche)
        {
            totalKgs = totalKgs + kg;
        }
        return totalKgs;
    }

    public int obtenerCantArchivos(ArrayList<AcopioEntity> acopios){
        int cant = 0;
        ArrayList<Integer> aux = new ArrayList<>();
        for (AcopioEntity acopio:acopios) {
            if (!(aux.contains(acopio.getIDarchivo()))) {
                aux.add(acopio.getIDarchivo());
            }
        }
        cant = aux.size();
        return cant;
    }

    public ArrayList<String> obtenerFechas(String codigo){
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();
        int id = obtenerCantArchivos(acopios);
        ArrayList<String> fechas = acopioRepository.fechasFiltro(id, codigo);
        return fechas;
    }

    public ArrayList<String> obtenerVariacionLeche(String codigo){
        ArrayList<String> salida= new ArrayList<>();
        String variacion = "0";
        String variacionNum= "0";
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();
        int cantArchivos = obtenerCantArchivos(acopios);
        if (cantArchivos != 1){
            ArrayList<AcopioEntity> acopioActualFiltrado = acopioRepository.findFiltro(cantArchivos, codigo);
            ArrayList<AcopioEntity> acopioAnteriorFiltrado = acopioRepository.findFiltro(cantArchivos-1, codigo);
            if (!(acopioAnteriorFiltrado.isEmpty())){
               int kilosActual = 0;
               int kilosAnterior = 0;

                for(AcopioEntity acopio:acopioActualFiltrado){
                    kilosActual = kilosActual + acopio.getKls_leche();
                }

                for(AcopioEntity acopio:acopioAnteriorFiltrado){
                    kilosAnterior = kilosAnterior + acopio.getKls_leche();
                }
                variacionNum=Integer.toString(kilosActual-kilosAnterior);
                int porcentaje = ((kilosActual*100)/kilosAnterior);
                variacion = Integer.toString(porcentaje);
            }
        }
        salida.add(variacionNum);
        salida.add(variacion);
        return salida;
    }

    public ArrayList<Boolean> obtenerTurnos(String codigo){
        ArrayList<Boolean> salida = new ArrayList<>();
        ArrayList<AcopioEntity> acopios = acopioRepository.getAll();
        int id = obtenerCantArchivos(acopios);
        ArrayList<String> turnos = acopioRepository.findTurnos(id, codigo);
        if(turnos.contains("M")) {
            salida.add(true);
        }
        else{
            salida.add(false);
        }
        if(turnos.contains("T")) {
            salida.add(true);
        }
        else{
            salida.add(false);
        }

        return salida;
    }

    public void eliminarData(ArrayList<AcopioEntity>datas){
        acopioRepository.deleteAll(datas);
    }
}
