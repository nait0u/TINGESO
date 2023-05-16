package MilkStgo.Pep1.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import jakarta.persistence.*;


@Entity
@Table(name = "acopio")
@NoArgsConstructor
@AllArgsConstructor
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
