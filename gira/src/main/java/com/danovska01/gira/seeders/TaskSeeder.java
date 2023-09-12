package com.danovska01.gira.seeders;

import com.danovska01.gira.models.ClassificaionName;
import com.danovska01.gira.models.Classification;
import com.danovska01.gira.models.Task;
import com.danovska01.gira.models.TaskProgress;
import com.danovska01.gira.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskSeeder implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public TaskSeeder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.taskRepository.count() == 0) {

            List<Task> tasks = Arrays.stream(TaskProgress.values())
                    .map(progress -> {
                        Task task = new Task();
                        task.setProgress(progress); // Set the name based on the enum name
                        return task;
                    })
                    .collect(Collectors.toList());


            this.taskRepository.saveAll(tasks);
            // n + 1 queries problem
        }

    }
}
