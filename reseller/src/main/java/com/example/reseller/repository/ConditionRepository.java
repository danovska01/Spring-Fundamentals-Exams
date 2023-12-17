package com.example.reseller.repository;

import com.example.reseller.model.entity.Condition;
import com.example.reseller.model.entity.enums.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, String> {
    Condition findByConditionName(ConditionNameEnum condition);

}
