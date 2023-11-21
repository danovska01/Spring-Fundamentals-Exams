package project.spotifyplaylist.init;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import project.spotifyplaylist.service.StyleService;

@Component
public class DatabaseInitializer implements CommandLineRunner{


    private final StyleService styleService;

    public DatabaseInitializer(StyleService styleService) {
        this.styleService = styleService;
    }


    @Override public void run(String... args) throws Exception {
     styleService.initStyles();
    }
}

