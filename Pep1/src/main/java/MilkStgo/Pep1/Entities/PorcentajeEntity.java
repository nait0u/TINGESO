package MilkStgo.Pep1.Entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "porcentaje")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PorcentajeEntity {

    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID_PORCENTAJE;
    private Integer ID_archivo;
    private String cod_proveedor;
    private int grasa;
    private int solido;
    private String fecha;

}
