package webapp.gira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webapp.gira.models.entities.Classification;
import webapp.gira.models.entities.enums.ClassificationName;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findByClassificationName(ClassificationName classificationName);
}
