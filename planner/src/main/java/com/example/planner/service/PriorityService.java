package com.example.planner.service;

import com.example.planner.model.entity.Priority;
import com.example.planner.model.entity.enums.PriorityNameEnum;

public interface PriorityService {
    void init ();

    Priority findByPriorityName(PriorityNameEnum priorityNameEnum);


}
