package com.danovska01.gira.models;

import javax.persistence.*;


@Entity
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "name", unique = true)
    private ClassificaionName classificationName;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Classification(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClassificaionName getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificaionName classificationName) {
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", classificationName=" + classificationName +
                ", description='" + description + '\'' +
                '}';
    }
}
