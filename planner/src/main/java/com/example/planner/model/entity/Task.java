package com.example.planner.model.entity;

import jakarta.persistence.*;


import java.time.LocalDate;


@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private LocalDate dueDate;


    @ManyToOne(fetch = FetchType.EAGER)
    private Priority priority;

    @ManyToOne(fetch = FetchType.EAGER)
    private User assignedTo;

    public Task() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User user) {
        this.assignedTo = user;
    }
}
