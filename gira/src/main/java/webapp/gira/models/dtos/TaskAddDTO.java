package webapp.gira.models.dtos;

import org.springframework.format.annotation.DateTimeFormat;
import webapp.gira.models.entities.enums.ClassificationName;
import webapp.gira.models.service.UserServiceModel;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddDTO {

    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationName classification;
    private UserServiceModel userServiceModel;

    public TaskAddDTO() {
    }

    @NotNull(message = "Name blank cannot be empty")
    public String getName() {
        return name;
    }

    public TaskAddDTO setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull
    @Size(min = 5, message = "Description length must be 5 characters")
    public String getDescription() {
        return description;
    }

    public TaskAddDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date cannot be in the past")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddDTO setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull(message = "You must select classification")
    public ClassificationName getClassification() {
        return classification;
    }

    public TaskAddDTO setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }

    public UserServiceModel getUserServiceModel() {
        return userServiceModel;
    }

    /**
     * This is set by task controller.
     *
     * @param userServiceModel
     */
    public void setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
    }
}
