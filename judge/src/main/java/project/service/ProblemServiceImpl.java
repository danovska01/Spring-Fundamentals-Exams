package project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.model.entity.Problem;
import project.model.entity.User;
import project.model.service.ProblemServiceModel;
import project.repository.ProblemRepository;
import project.util.CurrentUser;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService{

    private final ProblemRepository problemRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;

    public ProblemServiceImpl(ProblemRepository problemRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void create(ProblemServiceModel problemServiceModel) {
        Problem problem = modelMapper.map(problemServiceModel, Problem.class);
        User creator = userService.findById(currentUser.getId());
        problem.setUser(creator);

        problemRepository.save(problem);

    }

    @Override
    public List<Problem> getAllProblems() {
        return problemRepository.findAll();
    }

    @Override
    public Problem getProblemById(String id) {
        return problemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProblemById(String id) {
        problemRepository.deleteById(id);
    }
}
