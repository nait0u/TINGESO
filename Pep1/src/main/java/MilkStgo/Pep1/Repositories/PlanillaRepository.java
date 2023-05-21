package MilkStgo.Pep1.Repositories;

import MilkStgo.Pep1.Entities.PlanillaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanillaRepository extends JpaRepository<PlanillaEntity, String> {
    @Query("select e from PlanillaEntity e")
    PlanillaEntity find();

    @Query("delete from PlanillaEntity")
    void deleteAll();
}
