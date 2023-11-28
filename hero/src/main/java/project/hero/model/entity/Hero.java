package project.hero.model.entity;

import jakarta.persistence.*;
import project.hero.model.entity.enums.Class;

@Table(name = "heroes")
@Entity
public class Hero extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Class aClass;

    private Integer level;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    public Hero() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
