package learning.formation.Controllers;

import learning.formation.Entities.Formation;
import learning.formation.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/formations")
@PreAuthorize("hasRole('ADMIN')")
public class Admin_FormationController {

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

    @GetMapping("/title")
    public ResponseEntity<List<Formation>> getAllFormationsByTitle(@RequestParam String title) {
        try {
            List<Formation> formations = formationService.getFormationsByFormationTitle(title);
            return new ResponseEntity<>(formations, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<?> addFormation(@RequestBody Formation formation) {
        try {
            Formation createdFormation = formationService.addFormation(formation);
            return new ResponseEntity<>(createdFormation, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Error: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable int id, @RequestBody Formation formation) {
        try {
            Formation updatedFormation = formationService.updateFormation(id, formation);
            return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormationById(@PathVariable int id) {
        try {
            formationService.deleteFormationById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
