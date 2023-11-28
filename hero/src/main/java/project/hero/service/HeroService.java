package project.hero.service;

import project.hero.model.entity.Hero;
import project.hero.model.service.HeroServiceModel;

import java.util.List;

public interface HeroService {
    void create(HeroServiceModel heroServiceModel);

    List<Hero> getAllHeroes();

    Hero getHeroById(String id);

    void deleteHeroById(String id);
}
