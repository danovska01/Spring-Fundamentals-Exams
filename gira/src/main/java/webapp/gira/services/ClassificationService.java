package webapp.gira.services;

import webapp.gira.models.entities.Classification;
import webapp.gira.models.entities.enums.ClassificationName;

public interface ClassificationService {
    Classification findById(Long id);

    Classification findByName(ClassificationName classificationName);
}
