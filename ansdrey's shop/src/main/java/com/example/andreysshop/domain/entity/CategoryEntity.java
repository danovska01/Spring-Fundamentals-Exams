package com.example.andreysshop.domain.entity;

import com.example.andreysshop.domain.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private CategoryNameEnum categoryNameEnum;
    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
    }

    /*
    public CategoryEntity(CategoryNameEnum categoryNameEnum, String description) {
        this.categoryNameEnum = categoryNameEnum;
        this.description = description;
    }
*/
    public CategoryNameEnum getCategoryNameEnum() {
        return categoryNameEnum;
    }

    public CategoryEntity setCategoryNameEnum(CategoryNameEnum categoryNameEnum) {
        this.categoryNameEnum = categoryNameEnum;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
//•	Has a Name – an option between (Shirt, Denim, Shorts or Jacket)
//•	Has a Description