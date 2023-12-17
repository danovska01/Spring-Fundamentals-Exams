package com.example.planner.model.entity;

import com.example.planner.model.entity.enums.PriorityNameEnum;
import jakarta.persistence.*;

import java.util.Set;

@Table
@Entity(name = "priorities")
public class Priority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private PriorityNameEnum priorityName;

    @Column
    private String description;

    @OneToMany(mappedBy = "priority")
    private Set<Task> tasks;

    public Priority() {

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
