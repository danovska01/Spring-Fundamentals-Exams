package com.example.reseller.service;

import com.example.reseller.model.entity.Condition;
import com.example.reseller.model.entity.enums.ConditionNameEnum;
import com.example.reseller.repository.ConditionRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void initConditions() {
        if (conditionRepository.count() == 0) {
            Arrays.stream(ConditionNameEnum.values())
                    .forEach(name -> {
                        Condition condition = new Condition();
                        condition.setConditionName(name);

                        switch (name) {
                            case ACCEPTABLE ->
                                    condition.setDescription("The item is fairly worn but continues to function properly");
                            case GOOD -> condition.setDescription("Some signs of wear and tear or minor defects");
                            case EXCELLENT -> condition.setDescription("In perfect condition");

                        }

                        conditionRepository.save(condition);
                    });

        }
    }
}
