package project.likebook.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.likebook.model.entity.Post;
import project.likebook.model.entity.User;
import project.likebook.model.service.UserServiceModel;
import project.likebook.service.PostService;
import project.likebook.service.UserService;

import java.util.List;


@Controller
public class HomeController {
    private final PostService postService;
    private final UserService userService;


    public HomeController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;

    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {


        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        String userId = ((UserServiceModel)httpSession.getAttribute("user")).getId();

        User user = userService.findById(userId);

        List<Post> myPosts = postService.findMyPosts(userId);

        //       List<PostServiceModel> myPosts_ = myPosts.stream()
        //              .map(e -> modelMapper.map(e, PostServiceModel.class))
        //               .toList();

        model.addAttribute("myPosts", myPosts);

        model.addAttribute("userInfo", user);


        List<Post> otherPosts = postService.findOtherPosts(userId);
        //     List<PostServiceModel> otherPosts_ = otherPosts.stream()
        //            .map(e -> modelMapper.map(e, PostServiceModel.class))
        //             .toList();
        model.addAttribute("otherPosts", otherPosts);



        return "home";
    }





}
