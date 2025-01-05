package learning.formation.ServicesImpl;

import learning.formation.Entities.Formation;
import learning.formation.Repository.FormationRepository;
import learning.formation.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {
    @Autowired
    private FormationRepository formationRepository;


    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(int id) {
        return formationRepository.findById(id).orElse(null);
    }


    @Override
    public Formation addFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation updateFormation(int id, Formation updatedFormation) {
        Formation existingFormation = formationRepository.findById(id).orElse(null);

        if (existingFormation != null) {
            existingFormation.setTitle(updatedFormation.getTitle());
            existingFormation.setDescription(updatedFormation.getDescription());
            existingFormation.setPrice(updatedFormation.getPrice());
            existingFormation.setDuration(updatedFormation.getDuration());
            existingFormation.setImage(updatedFormation.getImage());

            return formationRepository.save(existingFormation);
        }

        return null;
    }


    @Override
    public void deleteFormationById(int id) {
        formationRepository.deleteById(id);
    }

    @Override
    public List<Formation> getFormationsByFormationTitle(String title) {
        return formationRepository.findByTitle(title);
    }
}
