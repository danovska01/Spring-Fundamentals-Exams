package project.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.model.binding.SubmissionAddBindingModel;
import project.model.entity.Problem;
import project.model.entity.Submission;
import project.model.service.SubmissionServiceModel;
import project.service.ProblemService;
import project.service.SubmissionService;
import project.service.UserService;
import project.util.CurrentUser;

@Controller
@RequestMapping("/problems")
public class SubmissionController {

    private final SubmissionService submissionService; // Inject the SubmissionService
    private final ProblemService problemService; // Inject the ProblemService
    private final UserService userService; // Inject the UserService
    private final ModelMapper modelMapper; // Inject the ModelMapper

    private  final CurrentUser currentUser;

    @Autowired
    public SubmissionController(SubmissionService submissionService, ProblemService problemService, UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.submissionService = submissionService;
        this.problemService = problemService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/submit/{id}")
    public String submit(@PathVariable String id, Model model){
        if(currentUser.getId() == null){
            return "redirect:/";
        }

        Problem problem = problemService.getProblemById(id);
        model.addAttribute("currentProblem", problem);

        return "create-submission";
    }

    @PostMapping("/submit/{id}")
    public String submitConfirm(@PathVariable String id, Model model,
                         @Valid SubmissionAddBindingModel submissionAddBindingModel,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (currentUser.getId() == null) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("submissionAddBindingModel", submissionAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.submissionAddBindingModel", bindingResult);
            return "redirect:/submit/{id}";
        }
//

        SubmissionServiceModel submissionServiceModel = modelMapper.map(submissionAddBindingModel, SubmissionServiceModel.class);
//        submissionServiceModel.setUser();
        submissionServiceModel.setProblem(problemService.getProblemById(id));

        submissionService.create(submissionServiceModel);

        return "details-submission"; // Redirect to the appropriate page

    }
}
