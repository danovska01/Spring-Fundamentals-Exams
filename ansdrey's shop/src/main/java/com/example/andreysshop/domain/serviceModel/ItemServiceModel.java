package com.example.andreysshop.domain.serviceModel;

import com.example.andreysshop.domain.entity.enums.CategoryNameEnum;

import java.math.BigDecimal;

public class ItemServiceModel {

    private Long id;
    private String name;
    private String description;
    private CategoryNameEnum category;
    private String gender;
    private BigDecimal price;

    public ItemServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemServiceModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
