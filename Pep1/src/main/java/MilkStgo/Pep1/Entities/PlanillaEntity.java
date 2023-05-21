package MilkStgo.Pep1.Entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planilla")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PlanillaEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID_PLANILLA;
    private String fecha;
    private String codigo;
    private String nombre;
    private String kls_leche;
    private String dias;
    private String promedio_kls;
    private String variacion_leche;
    private String grasa;
    private String variacion_grasa;
    private String solidos;
    private String variacion_solidos;
    private String pago_leche;
    private String pago_grasa;
    private String pago_solidos;
    private String bonificacion_frecuencia;
    private String descuento_variacion_leche;
    private String descuento_variacion_grasa;
    private String descuento_variacion_solidos;
    private String pago_total;
    private String monto_retencion;
    private String monto_final;


}
