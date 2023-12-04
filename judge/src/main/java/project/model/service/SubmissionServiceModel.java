package project.model.service;

import jakarta.persistence.*;
import project.model.entity.Problem;
import project.model.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public class SubmissionServiceModel {

    private List<String> code;

    private Integer achievedResult;
    private LocalDateTime createdOn;

    private Problem problem;

    private User user;


    public SubmissionServiceModel (){

    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public Integer getAchievedResult() {
        return achievedResult;
    }

    public void setAchievedResult(Integer achievedResult) {
        this.achievedResult = achievedResult;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
