package com.danovska01.coffeeshop.service;


import com.danovska01.coffeeshop.model.entity.Category;
import com.danovska01.coffeeshop.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}
