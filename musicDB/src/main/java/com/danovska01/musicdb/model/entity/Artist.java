package com.danovska01.musicdb.model.entity;

import com.danovska01.musicdb.model.entity.enums.ArtistNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{
    @Enumerated(EnumType.STRING)
    private ArtistNameEnum name;
    @Column(name="career_information", columnDefinition = "TEXT")
    private String careerInformation;

    public Artist() {
    }

    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
