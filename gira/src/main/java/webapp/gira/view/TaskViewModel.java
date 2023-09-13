package webapp.gira.view;

import webapp.gira.models.entities.enums.ClassificationName;
import webapp.gira.models.entities.enums.Progress;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private String assignedTo;
    private ClassificationName classification;
    private LocalDate dueDate;
    private Progress progress;

    public TaskViewModel() {
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

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public ClassificationName getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationName classification) {
        this.classification = classification;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Progress getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(Progress progress) {
        this.progress = progress;
        return this;
    }
}
