package webapp.gira.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import webapp.gira.models.entities.Classification;
import webapp.gira.models.entities.enums.ClassificationName;
import webapp.gira.repositories.ClassificationRepository;

@Component
public class Initialliser implements CommandLineRunner {

    private final ClassificationRepository classificationRepository;

    public Initialliser(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (classificationRepository.count() == 0) {
            Classification bug = new Classification(ClassificationName.BUG);
            Classification feature = new Classification(ClassificationName.FEATURE);
            Classification support = new Classification(ClassificationName.SUPPORT);
            Classification other = new Classification(ClassificationName.OTHER);

            classificationRepository.save(bug);
            classificationRepository.save(feature);
            classificationRepository.save(support);
            classificationRepository.save(other);
        }
    }
}
