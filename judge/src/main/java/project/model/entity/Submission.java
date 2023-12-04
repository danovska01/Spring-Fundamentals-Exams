package project.model.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "submissions")
@Entity
public class Submission extends BaseEntity{
    @ElementCollection
    @CollectionTable(name = "submission_code", joinColumns = @JoinColumn(name = "submission_id"))
    @Column(name = "code")
    private List<String> code;
    @Column(name = "achieved_result", nullable = false)
    private Integer achievedResult;
    private LocalDateTime createdOn;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Problem problem;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public Submission(){
        this.code= new ArrayList<>();
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
