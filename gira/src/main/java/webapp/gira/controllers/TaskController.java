package webapp.gira.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import webapp.gira.models.dtos.TaskAddDTO;
import webapp.gira.models.entities.enums.ClassificationName;
import webapp.gira.models.service.TaskServiceModel;
import webapp.gira.services.TaskService;
import webapp.gira.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final UserService userService;
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(UserService userService, TaskService taskService, ModelMapper modelMapper) {
        this.userService = userService;
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddDTO());
            model.addAttribute("classifications", ClassificationName.values());
        }


        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddDTO taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return "add-task";
        }


        taskAddBindingModel.setUserServiceModel(userService.getUserServiceModel());

        TaskServiceModel taskServiceModel = modelMapper.map(taskAddBindingModel, TaskServiceModel.class);


        taskService.addTask(taskServiceModel);

        return "redirect:/";
    }

    @GetMapping("/progress/{id}")
    public String changeProgress(@PathVariable Long id) {
        taskService.changeProgress(id);

        return "redirect:/";
    }
}
