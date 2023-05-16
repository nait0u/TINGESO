package MilkStgo.Pep1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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
    private String cod_proveedor;
    private int grasa;
    private int solido;
    private String fecha;

}
