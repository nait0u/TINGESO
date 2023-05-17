package MilkStgo.Pep1.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "acopio")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AcopioEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDACOPIO;

    private String fecha;
    private String turno;
    private String proveedor;
    private String kls_leche;

}
