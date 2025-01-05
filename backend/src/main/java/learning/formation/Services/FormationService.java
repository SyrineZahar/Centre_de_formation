package learning.formation.Services;

import learning.formation.Entities.Formation;

import java.util.List;

public interface FormationService {
    List<Formation> getAllFormations();

    Formation getFormationById(int id);

    Formation addFormation(Formation formation);

    Formation updateFormation(int id,Formation formation);

    void deleteFormationById(int id);
}
