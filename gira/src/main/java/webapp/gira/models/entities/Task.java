package webapp.gira.models.entities;

import org.springframework.format.annotation.DateTimeFormat;
import webapp.gira.models.entities.enums.Progress;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Progress getProgress() {
        return progress;
    }

    public Task setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }

    @Column(name = "due_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date cannot be in the past")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @OneToOne
    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
