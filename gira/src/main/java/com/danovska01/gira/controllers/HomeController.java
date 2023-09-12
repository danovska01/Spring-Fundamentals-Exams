package com.danovska01.gira.controllers;

import com.danovska01.gira.models.Task;
import com.danovska01.gira.models.User;
import com.danovska01.gira.services.TaskService;
import com.danovska01.gira.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final TaskService taskService;
    private final UserService userService;

    public HomeController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal) {
        // Retrieve tasks from the database using a service method
        List<Task> tasks = taskService.getAllTasks();

        // Add the list of tasks to the model so it can be accessed in the Thymeleaf template
        model.addAttribute("tasks", tasks);

        // Get the currently logged-in user's username
        String username = principal.getName();
        model.addAttribute("username", username);

        // Return the name of the Thymeleaf template for the home page
        return "home";
    }

    @GetMapping("/add-task")
    public String showAddTaskForm(Model model) {
        // Create a new Task object to bind the form data
        Task task = new Task();
        model.addAttribute("task", task);

        return "add-task";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute("task") @Valid Task task, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "add-task";
        }

        // Set the user for the task (you may need to retrieve the user from the database)
        // For this example, we assume you have a method userService.getUserByUsername
        // that returns the User object based on the username
        String username = principal.getName();
        Optional<User> user = userService.getUserByUsername(username);
        task.setUser(user);

        // Save the task to the database using a service method
        taskService.saveTask(task);

        redirectAttributes.addFlashAttribute("successMessage", "Task added successfully!");

        // Redirect to the home page after adding the task
        return "redirect:/home/";
    }

    @GetMapping("/logout")
    public String logout() {
        // Implement your logout logic here (e.g., invalidate the session)
        return "redirect:/login?logout";
    }
}
