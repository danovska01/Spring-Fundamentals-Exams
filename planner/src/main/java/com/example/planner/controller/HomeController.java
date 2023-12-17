package com.example.planner.controller;



import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.User;
import com.example.planner.service.TaskService;
import com.example.planner.service.UserService;
import com.example.planner.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/")
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final UserService userService;


    public HomeController(CurrentUser currentUser, TaskService taskService, UserService userService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
        this.userService = userService;
    }
//    @GetMapping("/")
//    public String index(Model model){
//        if(currentUser.getId() == null){
//            return "index";
//        }
//
//        // Instead of 3 queries to DB it can happen with one query - take all and later filter
//        Set<Task> ownTasks = taskService.findAllByAssignedTo_Id(currentUser.getId());
//        Set<Task> otherTasks = taskService.getAllUnassignedTasks();
//        model.addAttribute("username", currentUser.getUsername());
//
//        model.addAttribute("ownTasks", ownTasks);
//        model.addAttribute("otherTasks", otherTasks);
//
//
//        return "home";
//    }
@GetMapping("/")
public String index(Model model){
    if(currentUser.getId() == null){
        return "index";
    }
    Set<User> allUsers = userService.getAllOtherUsers();
    model.addAttribute("allOtherUsers", allUsers);

    //  List<Integer> sizes = allUsers.stream().map(user -> user.getOffers().size()).collect(Collectors.toList());
    int totalSize = allUsers.stream()
            .collect(Collectors.summingInt(user -> user.getAssignedTasks().size()));
    model.addAttribute("total", totalSize);


    //     List<Offer> allOffers = offerService.getAllOffers();
    //     model.addAttribute("allOffers", allOffers);

    Set<Task> ownTasks = taskService.getOwnTasks();
    //  Set<Offer> ownOffers = allOffers.stream().filter(o -> o.getUser().getId().equals(currentUser.getId())).collect(Collectors.toSet());
    model.addAttribute("ownTasks", ownTasks);

    Set<Task> other = taskService.getAllUnassignedTasks();
    model.addAttribute("otherTasks", ownTasks);  // TODO

    return "home";
}
}
