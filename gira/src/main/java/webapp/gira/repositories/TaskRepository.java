package webapp.gira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webapp.gira.models.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
