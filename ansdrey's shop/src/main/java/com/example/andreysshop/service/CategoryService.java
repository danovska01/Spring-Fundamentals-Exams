package com.example.andreysshop.service;

import com.example.andreysshop.domain.entity.CategoryEntity;
import com.example.andreysshop.domain.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategoryNameEnum(CategoryNameEnum category);
}
