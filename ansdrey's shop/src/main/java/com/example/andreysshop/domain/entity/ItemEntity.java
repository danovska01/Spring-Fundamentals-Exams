package com.example.andreysshop.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class ItemEntity extends BaseEntity {


    @Column(unique = true, nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(nullable = false)
    private String gender;

    public ItemEntity() {
    }

    public String getName() {
        return name;
    }

    public ItemEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public ItemEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public ItemEntity setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
//•	Has a Name (unique)
//o	Username must be unique
//o	Username length must be more than two characters

//•	Has a Description
//o	Description length must be more than three characters

//•	Has a Price
//o	Price must be positive number

//•	Has a Category
//o	Has a relation with Categories

//•	Has a Gender – an option between (Male and Female)