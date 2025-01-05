package learning.formation.Repository;

import learning.formation.Entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
    List<Formation> findByTitle(String title);
}
