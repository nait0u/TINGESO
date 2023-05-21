package MilkStgo.Pep1.Services;

import MilkStgo.Pep1.Entities.PorcentajeEntity;
import MilkStgo.Pep1.Repositories.AcopioRepository;
import MilkStgo.Pep1.Repositories.PorcentajeRepository;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PorcentajeService {

    @Autowired
    PorcentajeRepository porcentajeRepository;

    @Autowired
    AcopioRepository acopioRepository;

    public int obtenerCantArchivos(ArrayList<PorcentajeEntity> porcentajes){
        int cant = 0;
        ArrayList<Integer> aux = new ArrayList<>();
        for (PorcentajeEntity porcentaje:porcentajes) {
            if (!(aux.contains(porcentaje.getID_archivo())))
            {
                aux.add(porcentaje.getID_archivo());
            }
        }

        cant = aux.size();
        return cant;
    }

    public ArrayList<PorcentajeEntity> obtenerPorcentaje() {
        return (ArrayList<PorcentajeEntity>) porcentajeRepository.findAll();
    }


    public int obtenerGrasa(String codigo){
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes);

        PorcentajeEntity porcentajeActualFiltrado = porcentajeRepository.findFiltro(id, codigo);
        int grasa = porcentajeActualFiltrado.getGrasa();

        return grasa;
    }

    public int obtenerSolido(String codigo){
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes);

        PorcentajeEntity porcentajeActualFiltrado = porcentajeRepository.findFiltro(id, codigo);
        int solido = porcentajeActualFiltrado.getSolido();

        return solido;
    }

    public String obtenerDiferenciaGrasa(String codigo){
        ArrayList<PorcentajeEntity> porcentajes = porcentajeRepository.getAll();
        int id = obtenerCantArchivos(porcentajes);
        String variacion= "0";

        if(id==1){
            variacion="0";
        }else{
            PorcentajeEntity porcentajeActual = porcentajeRepository.findFiltro(id, codigo);
            PorcentajeEntity porcentajeAnterior = porcentajeRepository.findFiltro(id-1, codigo);
            if (porcentajeAnterior != null){
                int porcentaje= (porcentajeActual.getGrasa() *100)/(porcentajeAnterior.getGrasa());
                variacion= Integer.toString(porcentaje);
            }
        }
        return variacion;

    }

    public String obtenerDiferenciaSolido(String codigo){
        ArrayList<PorcentajeEntity> porcentajes = obtenerPorcentaje();
        int id = obtenerCantArchivos(porcentajes);
        String variacion= "0";
        if(id==1){
            variacion="0";
        }else{
            PorcentajeEntity porcentajeActual = porcentajeRepository.findFiltro(id, codigo);
            PorcentajeEntity porcentajeAnterior = porcentajeRepository.findFiltro(id-1, codigo);
            if(porcentajeAnterior != null){
                int porcentaje= (porcentajeActual.getSolido() *100)/(porcentajeAnterior.getSolido());
                variacion= Integer.toString(porcentaje);
            }
        }
        return variacion;
    }

    @Generated
    public void eliminarData(ArrayList<PorcentajeEntity> datas){
    porcentajeRepository.deleteAll(datas);
    }

}