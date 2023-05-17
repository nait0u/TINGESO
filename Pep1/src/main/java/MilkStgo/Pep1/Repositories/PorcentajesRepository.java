package MilkStgo.Pep1.Repositories;

import MilkStgo.Pep1.Entities.PorcentajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PorcentajesRepository extends JpaRepository<PorcentajeEntity, String> {
}
