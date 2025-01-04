package learning.formation.EntitiesTest;

import learning.formation.Entities.Formation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FormationTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidFormation() {
        Formation formation = new Formation();
        formation.setTitle("Java Programming");
        formation.setDescription("Learn Java from scratch.");
        formation.setPrice(99.99);
        formation.setDuration(30);
        formation.setImage("image.jpg");

        Set<ConstraintViolation<Formation>> violations = validator.validate(formation);

        assertTrue(violations.isEmpty(), "Formation should be valid");
    }

    @Test
    public void testInvalidFormationWithNullTitle() {
        Formation formation = new Formation();
        formation.setTitle(null);  // Null value to test validation
        formation.setDescription("Learn Java from scratch.");
        formation.setPrice(99.99);
        formation.setDuration(30);
        formation.setImage("image.jpg");

        Set<ConstraintViolation<Formation>> violations = validator.validate(formation);

        assertFalse(violations.isEmpty(), "Formation should be invalid due to null title");
        assertTrue(violations.iterator().next().getMessage().contains("Title is required"), "Expected 'Title is required' message");
    }

    @Test
    public void testInvalidFormationWithNegativePrice() {
        Formation formation = new Formation();
        formation.setTitle("Java Programming");
        formation.setDescription("Learn Java from scratch.");
        formation.setPrice(-50.0);
        formation.setDuration(30);
        formation.setImage("image.jpg");

        Set<ConstraintViolation<Formation>> violations = validator.validate(formation);

        assertFalse(violations.isEmpty(), "Formation should be invalid due to negative price");
        assertTrue(violations.iterator().next().getMessage().contains("Price must be positive"), "Expected 'Price must be positive' message");
    }

    @Test
    public void testInvalidFormationWithZeroDuration() {
        Formation formation = new Formation();
        formation.setTitle("Java Programming");
        formation.setDescription("Learn Java from scratch.");
        formation.setPrice(99.99);
        formation.setDuration(0);  // Zero value to test validation
        formation.setImage("image.jpg");

        Set<ConstraintViolation<Formation>> violations = validator.validate(formation);

        assertFalse(violations.isEmpty(), "Formation should be invalid due to zero duration");
        assertTrue(violations.iterator().next().getMessage().contains("Duration must be positive"), "Expected 'Duration must be positive' message");
    }

    @Test
    public void testInvalidFormationWithNullDescription() {
        Formation formation = new Formation();
        formation.setTitle("Java Programming");
        formation.setDescription(null);  // Null value to test validation
        formation.setPrice(99.99);
        formation.setDuration(30);
        formation.setImage("image.jpg");

        Set<ConstraintViolation<Formation>> violations = validator.validate(formation);

        assertFalse(violations.isEmpty(), "Formation should be invalid due to null description");
        assertTrue(violations.iterator().next().getMessage().contains("Description is required"), "Expected 'Description is required' message");
    }
}
