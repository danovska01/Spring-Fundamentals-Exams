package project.likebook.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.likebook.service.MoodService;

@Component
public class DatabaseInitializer implements CommandLineRunner{

    private final MoodService moodService;


    public DatabaseInitializer(MoodService moodService) {
        this.moodService = moodService;

    }

    @Override public void run(String... args) throws Exception {
        moodService.initMoods();
    }
}

