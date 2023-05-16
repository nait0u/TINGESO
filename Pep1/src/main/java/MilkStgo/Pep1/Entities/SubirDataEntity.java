package MilkStgo.Pep1.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Entity
@Table(name = "data")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SubirDataEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    private String fecha;
    private String turno;
    private String proveedor;
    private String kls_leche;
}
