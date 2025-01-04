package learning.formation.EntitiesTest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import learning.formation.Entities.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidAdmin() {
        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setUsername("johndoe");
        admin.setEmail("john.doe@example.com");
        admin.setPhone("123456789");
        admin.setPassword("Password123");

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);

        assertTrue(violations.isEmpty(), "Admin should be valid");
    }

    @Test
    public void testInvalidAdmin_missingFirstName() {
        Admin admin = new Admin();
        admin.setLastName("Doe");
        admin.setUsername("johndoe");
        admin.setEmail("john.doe@example.com");
        admin.setPhone("123456789");
        admin.setPassword("Password123");

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);

        assertFalse(violations.isEmpty(), "Admin should be invalid due to missing first name");
        assertEquals("First name is required", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidAdmin_invalidEmail() {
        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setUsername("johndoe");
        admin.setEmail("invalid-email");
        admin.setPhone("123456789");
        admin.setPassword("Password123");

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);

        assertFalse(violations.isEmpty(), "Admin should be invalid due to invalid email");
        assertEquals("Email should be valid", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidAdmin_shortUsername() {
        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setUsername("j");
        admin.setEmail("john.doe@example.com");
        admin.setPhone("123456789");
        admin.setPassword("Password123");

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);

        assertFalse(violations.isEmpty(), "Admin should be invalid due to short username");
        assertEquals("Username must be between 2 and 20 characters", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidAdmin_invalidPhoneNumber() {
        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setUsername("johndoe");
        admin.setEmail("john.doe@example.com");
        admin.setPhone("123abc456");
        admin.setPassword("Password123");

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);

        assertFalse(violations.isEmpty(), "Admin should be invalid due to invalid phone number");
        assertEquals("Phone number must be between 8 and 15 digits", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidAdmin_missingPassword() {
        Admin admin = new Admin();
        admin.setFirstName("John");
        admin.setLastName("Doe");
        admin.setUsername("johndoe");
        admin.setEmail("john.doe@example.com");
        admin.setPhone("123456789");

        Set<ConstraintViolation<Admin>> violations = validator.validate(admin);

        assertFalse(violations.isEmpty(), "Admin should be invalid due to missing password");
        assertEquals("Password is required", violations.iterator().next().getMessage());
    }
}
