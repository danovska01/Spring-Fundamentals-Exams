package project.likebook.service;


import project.likebook.model.entity.Mood;
import project.likebook.model.entity.enums.MoodName;

public interface MoodService {


    void initMoods();


    Mood findByMoodName(MoodName moodName);

}
