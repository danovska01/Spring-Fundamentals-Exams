package com.example.reseller.model.entity;

import com.example.reseller.model.entity.enums.ConditionNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ConditionNameEnum conditionName;
    @Column(nullable = false)
    private String description;
    public Condition(){

    }

    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
