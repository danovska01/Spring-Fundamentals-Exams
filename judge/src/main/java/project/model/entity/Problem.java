package project.model.entity;

import jakarta.persistence.*;

@Table(name = "problems")
@Entity
public class Problem extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Integer points;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public Problem (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
