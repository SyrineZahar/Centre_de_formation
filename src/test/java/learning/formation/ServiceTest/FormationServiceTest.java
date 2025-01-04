package learning.formation.ServiceTest;


import learning.formation.Entities.Formation;
import learning.formation.Repository.FormationRepository;
import learning.formation.ServicesImpl.FormationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FormationServiceTest {

    @Mock
    private FormationRepository formationRepository;

    @InjectMocks
    private FormationServiceImpl formationService;

    private Formation formation;

    @BeforeEach
    public void setUp() {
        formation = new Formation();
        formation.setId(1);
        formation.setTitle("Java Programming");
        formation.setDescription("Learn Java from scratch.");
        formation.setPrice(99.99);
        formation.setDuration(30);
        formation.setImage("image.jpg");
    }

    @Test
    public void testGetAllFormations() {
        List<Formation> formations = new ArrayList<>();
        formations.add(formation);

        Mockito.when(formationRepository.findAll()).thenReturn(formations);

        List<Formation> result = formationService.getAllFormations();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Java Programming", result.get(0).getTitle());
    }

    @Test
    public void testGetFormationById() {
        Mockito.when(formationRepository.findById(1)).thenReturn(Optional.of(formation));

        Formation result = formationService.getFormationById(1);

        assertNotNull(result);
        assertEquals("Java Programming", result.getTitle());
        assertEquals(99.99, result.getPrice());
    }

    @Test
    public void testAddFormation() {
        Mockito.when(formationRepository.save(formation)).thenReturn(formation);

        Formation result = formationService.addFormation(formation);

        assertNotNull(result);
        assertEquals("Java Programming", result.getTitle());
    }

    @Test
    public void testUpdateFormation() {
        Formation updatedFormation = new Formation();
        updatedFormation.setId(1);
        updatedFormation.setTitle("Advanced Java");
        updatedFormation.setDescription("Learn advanced Java concepts.");
        updatedFormation.setPrice(199.99);
        updatedFormation.setDuration(60);
        updatedFormation.setImage("newImage.jpg");

        Mockito.when(formationRepository.findById(1)).thenReturn(Optional.of(formation));

        Mockito.when(formationRepository.save(Mockito.any(Formation.class))).thenReturn(updatedFormation);

        Formation result = formationService.updateFormation(1, updatedFormation);

        assertNotNull(result);
        assertEquals("Advanced Java", result.getTitle());
        assertEquals(199.99, result.getPrice());
        assertEquals(60, result.getDuration());
        assertEquals("newImage.jpg", result.getImage());
    }




    @Test
    public void testUpdateFormationNotFound() {
        Formation updatedFormation = new Formation();
        updatedFormation.setId(1);
        updatedFormation.setTitle("Advanced Java");
        updatedFormation.setDescription("Learn advanced Java concepts.");
        updatedFormation.setPrice(199.99);
        updatedFormation.setDuration(60);
        updatedFormation.setImage("newImage.jpg");

        Mockito.when(formationRepository.findById(1)).thenReturn(Optional.empty());

        Formation result = formationService.updateFormation(1, updatedFormation);

        assertNull(result, "Formation should not be updated if not found");
    }

    @Test
    public void testDeleteFormationById() {
        Mockito.doNothing().when(formationRepository).deleteById(1);

        formationService.deleteFormationById(1);

        Mockito.verify(formationRepository, Mockito.times(1)).deleteById(1);
    }
}