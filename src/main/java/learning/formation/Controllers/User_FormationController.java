package learning.formation.Controllers;

import learning.formation.Entities.Formation;
import learning.formation.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/formations")
public class User_FormationController {
    @Autowired
    private FormationService formationService;

    @GetMapping
    public ResponseEntity<List<Formation>> getAllFormations() {
        try {
            List<Formation> formations = formationService.getAllFormations();
            return new ResponseEntity<>(formations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getFormationById(@PathVariable int id) {
        try {
            Formation formation = formationService.getFormationById(id);
            return new ResponseEntity<>(formation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
