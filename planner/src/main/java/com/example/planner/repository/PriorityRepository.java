package com.example.planner.repository;

import com.example.planner.model.entity.Priority;
import com.example.planner.model.entity.enums.PriorityNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, String> {
    Optional<Object> findByPriorityName(PriorityNameEnum priorityNameEnum);
}
