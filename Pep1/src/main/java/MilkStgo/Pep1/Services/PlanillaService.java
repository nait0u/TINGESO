package MilkStgo.Pep1.Services;

import MilkStgo.Pep1.Entities.PlanillaEntity;
import MilkStgo.Pep1.Repositories.PlanillaRepository;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlanillaService {
    @Autowired
    PlanillaRepository planillaRepository;

    public void guardarPlanilla(String fecha,
                                String codigo,
                                String nombre,
                                String kl_leche,
                                String dias,
                                String promedio_kls,
                                String variacion_leche,
                                String grasa,
                                String variacion_grasa,
                                String solidos,
                                String variacion_st,
                                String pago_leche,
                                String pago_grasa,
                                String pago_solidos,
                                String bonif_freq,
                                String dct_variacion_leche,
                                String dct_variacion_grasa,
                                String dct_variacion_st,
                                String pago_total,
                                String monto_retencion,
                                String monto_final){
        PlanillaEntity planilla = new PlanillaEntity();
        planilla.setFecha(fecha);
        planilla.setCodigo(codigo);
        planilla.setNombre(nombre);
        planilla.setKls_leche(kl_leche);
        planilla.setDias(dias);
        planilla.setPromedio_kls(promedio_kls);
        planilla.setVariacion_leche(variacion_leche);
        planilla.setGrasa(grasa);
        planilla.setVariacion_grasa(variacion_grasa);
        planilla.setSolidos(solidos);
        planilla.setVariacion_solidos(variacion_st);
        planilla.setPago_leche(pago_leche);
        planilla.setPago_grasa(pago_grasa);
        planilla.setPago_solidos(pago_solidos);
        planilla.setBonificacion_frecuencia(bonif_freq);
        planilla.setDescuento_variacion_leche(dct_variacion_leche);
        planilla.setDescuento_variacion_grasa(dct_variacion_grasa);
        planilla.setDescuento_variacion_solidos(dct_variacion_st);
        planilla.setPago_total(pago_total);
        planilla.setMonto_retencion(monto_retencion);
        planilla.setMonto_final(monto_final);
        planillaRepository.save(planilla);
    }

    public PlanillaEntity getAll(){
        return planillaRepository.find();
    }

    @Generated
    public void eliminarData(ArrayList<PlanillaEntity> datas){
        planillaRepository.deleteAll(datas);
    }
}
