package com.example.planner.init;



import com.example.planner.service.PriorityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner{




    private final PriorityService priorityService;

    public DatabaseInitializer(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @Override public void run(String... args) throws Exception {
    priorityService.init();
    }
}

