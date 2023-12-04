package project.controller;

import project.model.entity.Problem;
import project.service.ProblemService;
import project.service.UserService;
import project.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;

    private final ProblemService problemService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, ProblemService problemService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.problemService = problemService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }

        List<Problem> problemSet = problemService.getAllProblems();
        model.addAttribute("problemSet", problemSet );

        return "home";
    }



}
