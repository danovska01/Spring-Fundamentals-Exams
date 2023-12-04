package dictionary.controller;

import dictionary.model.entity.Word;
import dictionary.model.entity.enums.LanguageNameEnum;
import dictionary.service.WordService;
import dictionary.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {


    private final CurrentUser currentUser;

    private final WordService wordService;

    public HomeController(CurrentUser currentUser, WordService wordService) {
        this.currentUser = currentUser;

        this.wordService = wordService;
    }


    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        // Вариант 1
        Set<Word> spanishWords = wordService.getAllByLanguage(LanguageNameEnum.SPANISH);
        Set<Word> germanyWords = wordService.getAllByLanguage(LanguageNameEnum.GERMAN);
        Set<Word> italyWords = wordService.getAllByLanguage(LanguageNameEnum.ITALIAN);
        Set<Word> frenchWords = wordService.getAllByLanguage(LanguageNameEnum.FRENCH);
        int totalWords = spanishWords.size() + germanyWords.size() + italyWords.size() + frenchWords.size();

        // Вариант 2 -> Преточване на всички записи веднъж и филтрация за всеки отделен сет ....



        model.addAttribute("spanishWords", spanishWords);
        model.addAttribute("germanyWords", germanyWords);
        model.addAttribute("italyWords", italyWords);
        model.addAttribute("frenchWords", frenchWords);
        model.addAttribute("totalWords", totalWords);


        return "home";
    }


}
