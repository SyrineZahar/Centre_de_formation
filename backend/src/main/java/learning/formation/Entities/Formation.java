package learning.formation.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Formation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be positive")
    private Integer duration;

    private LocalDateTime createdDate = LocalDateTime.now();

    private String image;  // Store the image as a byte array (LOB)

    public Formation() {
    }

    public Formation(int id, String title, String description, Double price, Integer duration, LocalDateTime createdDate, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.createdDate = createdDate;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "Title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotNull(message = "Title is required") String title) {
        this.title = title;
    }

    public @NotNull(message = "Description is required") String getDescription() {
        return description;
    }

    public void setDescription(@NotNull(message = "Description is required") String description) {
        this.description = description;
    }

    public @NotNull(message = "Price is required") @Positive(message = "Price must be positive") Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price is required") @Positive(message = "Price must be positive") Double price) {
        this.price = price;
    }

    public @NotNull(message = "Duration is required") @Positive(message = "Duration must be positive") Integer getDuration() {
        return duration;
    }

    public void setDuration(@NotNull(message = "Duration is required") @Positive(message = "Duration must be positive") Integer duration) {
        this.duration = duration;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
