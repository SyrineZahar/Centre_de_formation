package learning.formation.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "First name is required")
    private String firstName;

    @NotNull(message = "Last name is required")
    private String lastName;

    @NotNull(message = "Username is required")
    @Size(min = 2, max = 20, message = "Username must be between 2 and 20 characters")
    private String username;

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits")
    private String phone;

    private String role = "ADMIN";

    @NotNull(message = "Password is required")
    @Size(min = 5, message = "Password must be at least 5 characters")
    @Pattern(regexp = "(?=.*[A-Z])(?=.*[0-9]).*", message = "Password must contain at least one uppercase letter and one number")
    private String password;

    public Admin() {
    }

    public Admin(Long id, String firstName, String lastName, String username, String email, String phone, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public @NotNull(message = "First name is required") String getFirstName() {
        return firstName;
    }

    public @NotNull(message = "Last name is required") String getLastName() {
        return lastName;
    }

    public @NotNull(message = "Username is required") @Size(min = 2, max = 20, message = "Username must be between 2 and 20 characters") String getUsername() {
        return username;
    }

    public @NotNull(message = "Email is required") @Email(message = "Email should be valid") String getEmail() {
        return email;
    }

    public @NotNull(message = "Phone number is required") @Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits") String getPhone() {
        return phone;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(@NotNull(message = "First name is required") String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NotNull(message = "Last name is required") String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(@NotNull(message = "Username is required") @Size(min = 2, max = 20, message = "Username must be between 2 and 20 characters") String username) {
        this.username = username;
    }

    public void setEmail(@NotNull(message = "Email is required") @Email(message = "Email should be valid") String email) {
        this.email = email;
    }

    public void setPhone(@NotNull(message = "Phone number is required") @Pattern(regexp = "^[0-9]{8,15}$", message = "Phone number must be between 8 and 15 digits") String phone) {
        this.phone = phone;
    }

    public void setPassword(@NotNull(message = "Password is required") String password) {
        this.password = password;
    }
}
