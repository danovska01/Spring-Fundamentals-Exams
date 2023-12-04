package project.service;

import project.model.entity.Problem;
import project.model.service.ProblemServiceModel;

import java.util.List;

public interface ProblemService {
    void create(ProblemServiceModel problemServiceModel);

    List<Problem> getAllProblems();

    Problem getProblemById(String id);

    void deleteProblemById(String id);
}
