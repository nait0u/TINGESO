package MilkStgo.Pep1.Repositories;

import MilkStgo.Pep1.Entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


@Repository

public interface ProveedorRepository extends JpaRepository<ProveedorEntity,String> {
    @Query("select e from ProveedorEntity e where e.nombre = :nombre")
    ProveedorEntity findByNameCustomQuery(@Param("nombre") String nombre);

    @Query("select e.categoria from ProveedorEntity e where e.codigo = :codigo")
    String findCategory(@Param("codigo") String codigo);

    @Query("select e from ProveedorEntity e where e.codigo = :codigo")
    ProveedorEntity findByCodigo(@Param("codigo")String codigo);
}
