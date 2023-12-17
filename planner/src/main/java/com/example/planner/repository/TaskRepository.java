package com.example.planner.repository;

import com.example.planner.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task, String> {


    Set<Task> findAllByAssignedToIsNull();
    Set<Task> findAllByAssignedTo_Id(String id);
}
