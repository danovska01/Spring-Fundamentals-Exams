package project.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{
    @Column(unique = true, nullable = false)
     private String name;
    @Column(nullable = false)
     private Integer health;
    @Column(nullable = false)
     private Integer power;
    @Column(nullable = false)
     private LocalDate created;
    @ManyToOne
    @JoinColumn(nullable = false)
     private Category category;
    @ManyToOne
    @JoinColumn(nullable = false)
     private User user;


    public Ship() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
