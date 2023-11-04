package com.danovska01.shoppinglist.model.entity;


import com.danovska01.shoppinglist.model.entity.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{

    private CategoryName name;
    private String description;

    public Category() {
    }

    public Category(CategoryName categoryName, String description) {
        this.name = categoryName;
        this.description = description;
    }

    @Enumerated(EnumType.STRING)
    public CategoryName getName() {
        return name;
    }

    public void setName(CategoryName name) {
        this.name = name;
    }
    @Column(name="description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
