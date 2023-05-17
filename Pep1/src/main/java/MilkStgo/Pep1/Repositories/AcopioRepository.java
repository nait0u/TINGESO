package MilkStgo.Pep1.Repositories;

import MilkStgo.Pep1.Entities.AcopioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AcopioRepository extends JpaRepository<AcopioEntity, String> {



}
