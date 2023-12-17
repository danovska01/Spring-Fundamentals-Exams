package com.example.planner.service;

import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.User;
import com.example.planner.model.service.TaskServiceModel;

import java.util.List;
import java.util.Set;

public interface TaskService {

    void add (TaskServiceModel taskServiceModel);


    void removeTaskById(String id);


    void assignTaskWithId(String id, String userId);
    void assignTaskToUser(User user, Task task);

    void returnTask(String id, String userId);


    void removeTaskById(String taskId, String userId);

    Set<Task> getAllUnassignedTasks();

    Set<Task> findAllByAssignedTo_Id(String id);

    Set<Task> getOwnTasks();
}
