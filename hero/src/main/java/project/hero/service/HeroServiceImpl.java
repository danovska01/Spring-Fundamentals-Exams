package project.hero.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.hero.model.entity.Hero;
import project.hero.model.entity.User;
import project.hero.model.service.HeroServiceModel;
import project.hero.repository.HeroRepository;
import project.hero.util.CurrentUser;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    private final HeroRepository heroRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;

    public HeroServiceImpl(HeroRepository heroRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser) {
        this.heroRepository = heroRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void create(HeroServiceModel heroServiceModel) {

        Hero hero = modelMapper.map(heroServiceModel, Hero.class);
        User creator = userService.findById(currentUser.getId());
        hero.setUser(creator);

        heroRepository.save(hero);
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHeroById(String id) {
        return heroRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHeroById(String id) {
        heroRepository.deleteById(id);
    }
}
