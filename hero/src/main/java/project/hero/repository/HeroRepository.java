package project.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.hero.model.entity.Hero;

import java.util.List;

public interface HeroRepository extends JpaRepository<Hero, String> {
    List<Hero> findAllByOrderByLevelDesc();
}
