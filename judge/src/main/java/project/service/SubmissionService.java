package project.service;

import project.model.entity.Submission;

import project.model.service.SubmissionServiceModel;

public interface SubmissionService {

    Submission getSubmissionsByProblemId(String problemId);


    void create(SubmissionServiceModel submissionServiceModel);
}
