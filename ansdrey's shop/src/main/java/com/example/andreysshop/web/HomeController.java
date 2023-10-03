package com.example.andreysshop.web;

import com.example.andreysshop.service.ItemService;
import com.example.andreysshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ItemService itemService;

    public HomeController(CurrentUser currentUser, ItemService itemService) {
        this.currentUser = currentUser;
        this.itemService = itemService;
    }


    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {

        if (currentUser.getId() == null) {
            modelAndView.setViewName("index");
        } else {

            modelAndView.addObject("items", itemService.findAllItems());
            modelAndView.setViewName("home");

        }

        return modelAndView;
    }
}


/*
@GetMapping("/")
public String index(Model model) {
    if (currentUser.getId() == null) {
        return "index";
    }

    List<ItemViewModel> items = itemService.findAllItems();
    model.addAttribute("items", items);

    return "home";
}

 model.addAttribute("totalTime", orders
            .stream()
            .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
            .reduce(Integer::sum)
            .orElse(0));
    model.addAttribute("users", userService.findAllUsersAndCountOrdersDes());
 */