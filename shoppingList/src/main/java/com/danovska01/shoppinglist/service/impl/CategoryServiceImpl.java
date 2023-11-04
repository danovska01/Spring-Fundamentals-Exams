package com.danovska01.shoppinglist.service.impl;

import com.danovska01.shoppinglist.model.entity.Category;
import com.danovska01.shoppinglist.model.entity.enums.CategoryName;
import com.danovska01.shoppinglist.repository.CategoryRepository;
import com.danovska01.shoppinglist.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count() == 0){
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category(categoryName, "Descripton for " + categoryName);
                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public Category findByName(CategoryName categoryName) {
        return categoryRepository.findByName(categoryName).orElse(null);
    }
}
