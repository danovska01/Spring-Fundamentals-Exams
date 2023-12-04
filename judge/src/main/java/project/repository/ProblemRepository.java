package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.Problem;


public interface ProblemRepository extends JpaRepository<Problem, String> {
    Problem getProblemById(String id);
}
