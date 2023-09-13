package webapp.gira.services.impl;

import org.springframework.stereotype.Service;
import webapp.gira.models.entities.Classification;
import webapp.gira.models.entities.enums.ClassificationName;
import webapp.gira.repositories.ClassificationRepository;
import webapp.gira.services.ClassificationService;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public Classification findById(Long id) {
        return classificationRepository.findById(id).orElse(null);
    }

    @Override
    public Classification findByName(ClassificationName classificationName) {

        return classificationRepository.findByClassificationName(classificationName);
    }
}
