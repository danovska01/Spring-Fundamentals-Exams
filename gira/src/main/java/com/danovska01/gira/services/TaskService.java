package com.danovska01.gira.services;

import com.danovska01.gira.models.Task;
import com.danovska01.gira.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    // Add other methods as needed, such as deleteTask, getTaskById, etc.
}
