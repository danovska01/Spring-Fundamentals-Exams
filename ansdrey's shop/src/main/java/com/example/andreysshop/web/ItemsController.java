package com.example.andreysshop.web;

import com.example.andreysshop.domain.bindingModel.ItemBindingModel;
import com.example.andreysshop.domain.serviceModel.ItemServiceModel;
import com.example.andreysshop.service.ItemService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/items")
public class ItemsController {

    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemsController(ItemService itemService, ModelMapper modelMapper) {
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("itemBindingModel")) {
            model.addAttribute("itemBindingModel", new ItemBindingModel());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ItemBindingModel itemBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("itemBindingModel", itemBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.itemBindingModel",
                            bindingResult);
            return "redirect:add";
        }

        itemService.addItem(modelMapper.map(itemBindingModel, ItemServiceModel.class));


        return "redirect:/";
    }


    @GetMapping("/details/{id}")
    public ModelAndView detailsItem(@PathVariable("id") Long id, ModelAndView modelAndView) {

        modelAndView.addObject("item", this.itemService.findById(id));
        modelAndView.setViewName("details-item");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable("id") Long id) {
        itemService.delete(id);
        return "redirect:/";
    }


}

// @GetMapping("/details")
//    public ModelAndView detailsItem(@RequestParam("id")Long id, ModelAndView modelAndView) {
//
//        modelAndView.addObject("item", this.itemService.findById(id));
//        modelAndView.setViewName("details-item");
//
//        return modelAndView;
//    }