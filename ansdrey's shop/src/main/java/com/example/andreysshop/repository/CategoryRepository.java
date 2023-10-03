package com.example.andreysshop.repository;

import com.example.andreysshop.domain.entity.CategoryEntity;
import com.example.andreysshop.domain.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
