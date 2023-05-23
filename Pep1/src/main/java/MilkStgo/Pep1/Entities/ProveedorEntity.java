package MilkStgo.Pep1.Entities;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;



@Entity
@Table(name = "proveedores")
@NoArgsConstructor
@AllArgsConstructor
@Data


public class ProveedorEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer IDPROVEEDOR;
    private String codigo;
    private String nombre;
    private String categoria;
    private Boolean retencion;
}
