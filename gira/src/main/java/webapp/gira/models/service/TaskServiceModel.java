package webapp.gira.models.service;

import webapp.gira.models.entities.enums.ClassificationName;
import webapp.gira.models.entities.enums.Progress;

import java.time.LocalDate;

public class TaskServiceModel {

    private Long id;
    private String name;
    private String description;
    private Progress progress;
    private LocalDate dueDate;
    private ClassificationName classification;
    private UserServiceModel userServiceModel;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public void setClassification(ClassificationName classification) {
        this.classification = classification;
    }

    public UserServiceModel getUserServiceModel() {
        return userServiceModel;
    }

    public void setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
    }
}
