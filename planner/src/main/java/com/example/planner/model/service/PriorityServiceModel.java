package com.example.planner.model.service;

import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.enums.PriorityNameEnum;


import java.util.Set;

public class PriorityServiceModel {
    private String id;

    private PriorityNameEnum priorityName;

    private String description;

    private Set<Task> tasks;

    public PriorityServiceModel(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PriorityNameEnum getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(PriorityNameEnum priorityName) {
        this.priorityName = priorityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
