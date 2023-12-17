package com.example.planner.service;

import com.example.planner.model.entity.Priority;
import com.example.planner.model.entity.enums.PriorityNameEnum;
import com.example.planner.repository.PriorityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PriorityServiceImpl implements PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void init() {

        if(priorityRepository.count()==0){
            Arrays.stream(PriorityNameEnum.values())
                    .forEach(priorityNameEnum -> {
                        Priority priority = new Priority();
                        priority.setPriorityName(priorityNameEnum);
                        switch (priorityNameEnum){
                            case URGENT -> priority.setDescription("An urgent problem that blocks the system use until the issue is resolved.");
                            case LOW -> priority.setDescription("Should be fixed if time permits but can be postponed.");
                            case IMPORTANT -> priority.setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
                        }
                        priorityRepository.save(priority);
                    });
        }

    }

    @Override
    public Priority findByPriorityName(PriorityNameEnum priorityNameEnum) {
        return (Priority) priorityRepository.findByPriorityName(priorityNameEnum).orElse(null);
    }
}
