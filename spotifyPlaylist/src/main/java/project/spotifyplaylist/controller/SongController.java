package project.spotifyplaylist.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.spotifyplaylist.model.binding.SongAddBindingModel;
import project.spotifyplaylist.model.service.SongServiceModel;
import project.spotifyplaylist.service.SongService;
import project.spotifyplaylist.util.CurrentUser;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final CurrentUser currentUser;
    private final SongService songService;
    private final ModelMapper modelMapper;


    public SongController(CurrentUser currentUser, SongService songService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.modelMapper = modelMapper;
    }
    @GetMapping("/add")
    public String add(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("songAddBindingModel")){
            model.addAttribute("songAddBindingModel", new SongAddBindingModel());
        }
        return "song-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid SongAddBindingModel songAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("songAddBindingModel", songAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:/shongs/add";
        }
        songService.add(modelMapper.map(songAddBindingModel, SongServiceModel.class));


        return "redirect:/";
    }

    @GetMapping("/add/{id}")
    String likePost(@PathVariable String id){

        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        String userId = currentUser.getId();

        songService.addSong(id, userId);
        return "redirect:/";
    }
    @GetMapping("*")
    public String notFound(){
        return "redirect:/";
    }
}
