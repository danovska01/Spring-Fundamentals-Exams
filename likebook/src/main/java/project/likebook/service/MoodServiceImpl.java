package project.likebook.service;


import org.springframework.stereotype.Service;
import project.likebook.model.entity.Mood;
import project.likebook.model.entity.enums.MoodName;
import project.likebook.repository.MoodRepository;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {

        if(moodRepository.count() == 0){
            Arrays.stream(MoodName.values())
                    .forEach(moodName -> {
                        Mood mood = new Mood();
                        mood.setMoodName(moodName);
                        moodRepository.save(mood);
                    });
        }
    }

    @Override
    public Mood findByMoodName(MoodName moodName) {
        return moodRepository.findByMoodName(moodName).orElse(null);
    }


}
