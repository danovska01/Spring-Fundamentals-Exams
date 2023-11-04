package com.danovska01.shoppinglist.service;

import com.danovska01.shoppinglist.model.entity.Category;
import com.danovska01.shoppinglist.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
