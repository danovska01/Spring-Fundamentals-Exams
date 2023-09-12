package com.danovska01.gira.controllers;

import com.danovska01.gira.models.Task;
import com.danovska01.gira.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        // Retrieve tasks from the database using a service method
        List<Task> tasks = taskService.getAllTasks();

        // Add the list of tasks to the model so it can be accessed in the Thymeleaf template
        model.addAttribute("tasks", tasks);

        // Return the name of the Thymeleaf template for the home page
        return "home";
    }
}
