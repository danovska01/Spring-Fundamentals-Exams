package com.example.planner.service;

import com.example.planner.model.entity.Task;
import com.example.planner.model.entity.User;
import com.example.planner.model.service.TaskServiceModel;
import com.example.planner.repository.TaskRepository;
import com.example.planner.repository.UserRepository;
import com.example.planner.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TaskServiceImpl implements TaskService{
    private final PriorityService priorityService;
    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;

    private final CurrentUser currentUser;

    private final UserRepository userRepository;

    public TaskServiceImpl(PriorityService priorityService, ModelMapper modelMapper, TaskRepository taskRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.priorityService = priorityService;
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.currentUser = currentUser;

        this.userRepository = userRepository;
    }

    @Override
    public void add(TaskServiceModel taskServiceModel) {


        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setPriority(priorityService.findByPriorityName(taskServiceModel.getPriority().getPriorityName()));

//        UserServiceModel user = (UserServiceModel) httpSession.getAttribute("user");
//        task.setAssignedTo(modelMapper.map(user, User.class));

        taskRepository.save(task);
    }


    @Override
    public void removeTaskById(String id) {
    taskRepository.deleteById(id);
    }




    @Override
    public void assignTaskWithId(String taskId, String userId) {
       // UserServiceModel user = (UserServiceModel) httpSession.getAttribute("user");
//        task.setAssignedTo(modelMapper.map(user, User.class));
        User currentUser = (User) userRepository.findUserById(userId).orElse(null);
        Task taskById = taskRepository.findById(taskId).orElse(null);
        taskById.setAssignedTo(currentUser);
        taskRepository.save(taskById);
        currentUser.getAssignedTasks().add(taskById);

        userRepository.save(currentUser);
    }

    @Override
    public void assignTaskToUser(User user, Task task) {

    }


    @Override
    public void removeTaskById(String taskId, String userId) {
        User user = userRepository.findById(userId).orElse(null);
        Task task1 = user.getAssignedTasks().stream().filter(e -> e.getId().equals(taskId)).findFirst().orElse(null);
        boolean removed = user.getAssignedTasks().remove(task1);

        userRepository.save(user);
        taskRepository.delete(task1);
    }


    @Override
    public Set<Task> findAllByAssignedTo_Id(String id) {
        return taskRepository.findAllByAssignedTo_Id(id);
    }

    @Override
    public Set<Task> getOwnTasks() {
        String id = currentUser.getId();

//        return userRepository.findAllByUserId(id);
        return taskRepository.findAllByAssignedTo_Id(id);
    }
    @Override
    public Set<Task> getAllUnassignedTasks() {
        return taskRepository.findAllByAssignedToIsNull();

    }

    @Override
    public void returnTask(String taskId, String userId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        Task task1 = user.getAssignedTasks().stream().filter(e -> e.getId().equals(taskId)).findFirst().orElse(null);
        boolean remove = user.getAssignedTasks().remove(task1);
        task.setAssignedTo(null);
        taskRepository.save(task);
        userRepository.save(user);
    }


}
