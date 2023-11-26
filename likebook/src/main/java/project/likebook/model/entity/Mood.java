package project.likebook.model.entity;

import jakarta.persistence.*;
import project.likebook.model.entity.enums.MoodName;


@Table(name = "moods")
@Entity
public class Mood extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private MoodName moodName;
    @Column(name="description", columnDefinition = "TEXT")
    private String description;


    public Mood(){

    }

    public Mood(MoodName moodName, String description) {
        this.moodName = moodName;
        this.description = description;
    }

    public MoodName getMoodNameEnum() {
        return moodName;
    }

    public void setMoodNameEnum(MoodName moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MoodName getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodName moodName) {
        this.moodName = moodName;
    }
}
