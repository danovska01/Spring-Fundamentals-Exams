package project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.model.entity.Submission;
import project.model.service.SubmissionServiceModel;
import project.repository.ProblemRepository;
import project.repository.SubmissionRepository;

import java.time.LocalDateTime;

@Service
public class SubmissionServiceImpl implements SubmissionService{


    private final SubmissionRepository submissionRepository;
    private final ProblemRepository problemRepository;

    private final ModelMapper modelMapper;

    public SubmissionServiceImpl(SubmissionRepository submissionRepository, ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.submissionRepository = submissionRepository;
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }


//    @Override
//    public Submission create(Submission submission, String problemId) {
//        Optional<Problem> optionalProblem = problemRepository.findById(problemId);
//
//        if (optionalProblem.isPresent()) {
//            Problem problem = optionalProblem.get();
//
//            // Split the code from the textarea into lines
//            List<String> codeLines = Arrays.asList(submission.getCode().stream().spliterator().toString());
//            submission.setCode(codeLines);
//
//            // Set other properties
//            submission.setAchievedResult(new Random().nextInt(problem.getPoints() + 1));
//            submission.setCreatedOn(LocalDateTime.now());
//
//            // Associate the submission with the problem
//            submission.setProblem(problem);
//
//            // Additional validation and logic can be added here
//
//            // Save the submission
//            return submissionRepository.save(submission);
//        } else {
//            // Handle the case where the problem with the given id is not found
//            throw new IllegalArgumentException("Problem not found with id: " + problemId);
//        }
//    }


    @Override
    public Submission getSubmissionsByProblemId(String problemId) {
        return null;
    }

    @Override
    public void create(SubmissionServiceModel submissionServiceModel) {
//        Submission submission= modelMapper.map(submissionServiceModel, Submission.class);

 Submission submission = new Submission();

        // Assuming that you have appropriate setters in your Submission entity
        submission.setCode(submissionServiceModel.getCode());
        submission.setAchievedResult(200);
        submission.setCreatedOn(submissionServiceModel.getCreatedOn());
        submission.setProblem(submissionServiceModel.getProblem());
        submission.setUser(submissionServiceModel.getUser());
        submission.setCreatedOn(LocalDateTime.now());


        submissionRepository.save(submission);


    }


}
