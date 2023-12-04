package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.model.entity.Submission;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, String> {
    List<Submission> findByProblemId(String problemId);
}
