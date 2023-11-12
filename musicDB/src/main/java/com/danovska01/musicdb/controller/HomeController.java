package com.danovska01.musicdb.controller;

import com.danovska01.musicdb.model.entity.Album;
import com.danovska01.musicdb.service.AlbumService;
import com.danovska01.musicdb.util.CurrentUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, AlbumService albumService) {
        this.currentUser = currentUser;
        this.albumService = albumService;
    }

    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        List<Album> allAlbums = albumService.getAllAlbums();
        model.addAttribute("allAlbums", allAlbums);

        BigDecimal totalCopies = albumService.getNumberOfAllCopies();
        model.addAttribute("totalCopies", totalCopies);
        return "home";
    }
}
