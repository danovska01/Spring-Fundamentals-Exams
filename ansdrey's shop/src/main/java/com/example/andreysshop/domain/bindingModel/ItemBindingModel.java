package com.example.andreysshop.domain.bindingModel;

import com.example.andreysshop.domain.entity.enums.CategoryNameEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public class ItemBindingModel {

    @Length(min = 2, message = "Name length must be more than two characters")
    private String name;
    @Length(min = 3, message = "Description length must be more than three characters")
    private String description;
    @NotNull(message = "Enter valid category")
    private CategoryNameEnum category;
    @NotEmpty(message = "Enter valid gender")
    private String gender;
    @DecimalMin(value = "0", message = "Price must be positive number")
    private BigDecimal price = BigDecimal.valueOf(0);

    public ItemBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemBindingModel setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
