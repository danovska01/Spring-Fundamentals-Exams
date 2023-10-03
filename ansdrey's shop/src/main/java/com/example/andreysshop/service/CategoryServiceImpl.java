package com.example.andreysshop.service;

import com.example.andreysshop.domain.entity.CategoryEntity;
import com.example.andreysshop.domain.entity.enums.CategoryNameEnum;
import com.example.andreysshop.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {

        if (categoryRepository.count() != 0) {
            return;
        }

        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    CategoryEntity category = new CategoryEntity();


                    category.setCategoryNameEnum(categoryNameEnum);

                    switch (categoryNameEnum) {
                        case SHIRT -> category.setDescription("This is new shirt");
                        case DENIM -> category.setDescription("This is NEW DENIM");
                        case SHORTS -> category.setDescription("This is new shorts");
                        case JACKET -> category.setDescription("This is new jacket");
                    }
                    categoryRepository.save(category);
                });
/*
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    categoryRepository.save(new CategoryEntity(categoryNameEnum,
                            String.format("Description for %s", categoryNameEnum.name())));
                });
*/
    }

    @Override
    public CategoryEntity findByCategoryNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByCategoryNameEnum(category).orElse(null);
    }


}




