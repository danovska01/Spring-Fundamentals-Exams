package project.hero.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.hero.model.entity.Hero;
import project.hero.service.HeroService;
import project.hero.util.CurrentUser;

import java.util.List;


@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final HeroService heroService;

    public HomeController(CurrentUser currentUser, HeroService heroService) {
        this.currentUser = currentUser;
        this.heroService = heroService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }


        List<Hero> heroSet = heroService.getAllHeroes();
        model.addAttribute("heroSet", heroSet );



        return "home";
    }


}
