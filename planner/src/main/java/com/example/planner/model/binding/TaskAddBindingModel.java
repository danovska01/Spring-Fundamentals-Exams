package com.example.planner.model.binding;

import com.example.planner.model.entity.enums.PriorityNameEnum;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;

public class TaskAddBindingModel {


    private String description;
    private PriorityNameEnum priority;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    public TaskAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityNameEnum priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
