package webapp.gira.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import webapp.gira.models.entities.Task;
import webapp.gira.models.entities.enums.Progress;
import webapp.gira.models.service.TaskServiceModel;
import webapp.gira.repositories.TaskRepository;
import webapp.gira.services.ClassificationService;
import webapp.gira.services.TaskService;
import webapp.gira.services.UserService;
import webapp.gira.view.TaskViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final ClassificationService classificationService;
    private final UserService userService;
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    public TaskServiceImpl(ClassificationService classificationService, UserService userService, TaskRepository taskRepository, ModelMapper modelMapper) {
        this.classificationService = classificationService;
        this.userService = userService;
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        List<TaskViewModel> viewModels = new ArrayList<>();

        List<Task> tasks = taskRepository.findAll();

        tasks.forEach(task -> {
            TaskViewModel taskViewModel = new TaskViewModel();
            modelMapper.map(task, taskViewModel);
            taskViewModel.setAssignedTo(task.getUser().getUsername());
            taskViewModel.setClassification(task.getClassification().getClassificationName());
            taskViewModel.setProgress(task.getProgress());

            viewModels.add(taskViewModel);
        });

        return viewModels;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        Task task = modelMapper.map(taskServiceModel, Task.class);

        task.setProgress(Progress.OPEN);

        taskRepository.save(task);
    }

    @Override
    public void changeProgress(Long id) {
        Task task = taskRepository.findById(id).get();

        if (task.getProgress().equals(Progress.OPEN)) {
            task.setProgress(Progress.IN_PROGRESS);
            taskRepository.save(task);
        } else if (task.getProgress().equals(Progress.IN_PROGRESS)) {
            task.setProgress(Progress.COMPLETED);
            taskRepository.save(task);
        } else {
            taskRepository.deleteById(id);
        }
    }
}
