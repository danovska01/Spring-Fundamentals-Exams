package project.controller;

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
import project.model.binding.ProblemAddBindingModel;
import project.model.binding.SubmissionAddBindingModel;
import project.model.entity.Problem;
import project.model.service.ProblemServiceModel;
import project.model.service.SubmissionServiceModel;
import project.repository.ProblemRepository;
import project.service.ProblemService;
import project.service.SubmissionService;
import project.util.CurrentUser;

@Controller
@RequestMapping("/problems")
public class ProblemController {

    private final CurrentUser currentUser;
    private final ProblemService problemService;
    private final ModelMapper modelMapper;

    private final SubmissionService submissionService;

    private final ProblemRepository problemRepository;

    public ProblemController(CurrentUser currentUser, ProblemService problemService, ModelMapper modelMapper, SubmissionService submissionService, ProblemRepository problemRepository) {
        this.currentUser = currentUser;
        this.problemService = problemService;
        this.modelMapper = modelMapper;
        this.submissionService = submissionService;
        this.problemRepository = problemRepository;
    }

    @GetMapping("/create")
    public String create(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("problemAddBindingModel")){
            model.addAttribute("problemAddBindingModel", new ProblemAddBindingModel());
        }
        return "create-problem";
    }

    @PostMapping("/create")
    public String addConfirm(@Valid ProblemAddBindingModel problemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("problemAddBindingModel", problemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.problemAddBindingModel", bindingResult);
            return "redirect:/problems/create";
        }
        problemService.create(modelMapper.map(problemAddBindingModel, ProblemServiceModel.class));


        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model){
        if(currentUser.getId() == null){
            return "redirect:/";
        }

        Problem problem = problemService.getProblemById(id);
        model.addAttribute("currentProblem", problem);

        return "details-problem";
    }
//    @GetMapping("/submit/{id}")
//    public String submit(@PathVariable String id, Model model){
//        if(currentUser.getId() == null){
//            return "redirect:/";
//        }
//
//        Problem problem = problemService.getProblemById(id);
//        model.addAttribute("currentProblem", problem);
//
//        return "create-submission";
//    }

//    @PostMapping("/submit/{id}/process")
//    public String submitForm(@PathVariable String id,
//                             @Valid SubmissionAddBindingModel submissionAddBindingModel,
//                             BindingResult bindingResult,
//                             RedirectAttributes redirectAttributes) {
//        if (currentUser.getId() == null) {
//            return "redirect:/users/login";
//        }
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("submissionAddBindingModel", submissionAddBindingModel);
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.submissionAddBindingModel", bindingResult);
//            return "redirect:/submit/" + id;
//        }
//
//        SubmissionServiceModel submissionServiceModel = modelMapper.map(submissionAddBindingModel, SubmissionServiceModel.class);
//        // Set other properties for the submission, e.g., user, problem, etc.
//        submissionService.create(submissionServiceModel);
//
//        return "details-submission";
//    }





//    @GetMapping("/deleteProblem/{id}")
//    public String deleteConfirm(@PathVariable String id){
//        if(currentUser.getId() == null){
//            return "redirect:/";
//        }
//
//        problemService.deleteProblemById(id);
//        return "redirect:/";
//    }
}
