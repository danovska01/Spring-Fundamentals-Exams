package com.example.planner.controller;

import com.example.planner.model.binding.TaskAddBindingModel;
import com.example.planner.model.entity.User;
import com.example.planner.model.service.TaskServiceModel;
import com.example.planner.model.service.UserServiceModel;
import com.example.planner.service.TaskService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;


    public TaskController(TaskService taskService, ModelMapper modelMapper, HttpSession httpSession) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }
    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user") == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("taskAddBindingModel")){
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }
        return "task-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:/tasks/add";
        }

        taskService.add(modelMapper.map(taskAddBindingModel, TaskServiceModel.class));

        return "home";
    }

    @GetMapping("/assign-task/{id}")
    public String assignTask(@PathVariable String id, HttpSession httpSession) {
        // Check if user is logged in
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/home";
        }

        // Retrieve the user object from the session
        User user = (User) httpSession.getAttribute("user");

        // Get the user id
        String userId = user.getId();

        // Call taskService.assignTaskWithId with the retrieved user id
        taskService.assignTaskWithId(id, userId);

        return "redirect:/";
    }



    @GetMapping("/remove/{id}")
    public String removeTask(@PathVariable String id) {
        if(httpSession.getAttribute("user") == null){
            return "redirect:/home";
        }

        taskService.removeTaskById(id);


        return "redirect:/";
    }

    @GetMapping("/return/{id}")
    public String returnTask(@PathVariable String id, HttpSession httpSession) {
        // Check if user is logged in
        if (httpSession.getAttribute("user") == null) {
            return "redirect:/home";
        }

        UserServiceModel userServiceModel = (UserServiceModel) httpSession.getAttribute("user");
        String userId = userServiceModel.getId();


        // Call taskService.returnTask with userId
        taskService.returnTask(id, userId);

        return "redirect:/";
    }



}
