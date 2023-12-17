package com.example.planner.model.service;

import com.example.planner.model.entity.Priority;
import com.example.planner.model.entity.User;


import java.time.LocalDate;


public class TaskServiceModel {
    private String id;

    private String description;

    private LocalDate dueDate;

    private Priority priority;

    private User assignedTo;

    public TaskServiceModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public User getUser() {
        return assignedTo;
    }

    public void setUser(User user) {
        this.assignedTo = user;
    }
}
