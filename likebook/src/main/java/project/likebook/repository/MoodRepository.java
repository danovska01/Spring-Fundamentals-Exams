package project.likebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.likebook.model.entity.Mood;
import project.likebook.model.entity.enums.MoodName;

import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, String> {
    Optional<Mood> findByMoodName(MoodName moodName);
}
