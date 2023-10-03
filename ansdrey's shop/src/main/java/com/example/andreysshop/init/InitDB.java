package com.example.andreysshop.init;

import com.example.andreysshop.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements CommandLineRunner {

    private final CategoryService categoryService;

    public InitDB(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {

        categoryService.initCategories();
    }
}
