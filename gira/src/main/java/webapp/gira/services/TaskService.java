package webapp.gira.services;

import webapp.gira.models.service.TaskServiceModel;
import webapp.gira.view.TaskViewModel;

import java.util.List;

public interface TaskService {

    List<TaskViewModel> getAllTasks();

    void addTask(TaskServiceModel taskServiceModel);

    void changeProgress(Long id);
}
