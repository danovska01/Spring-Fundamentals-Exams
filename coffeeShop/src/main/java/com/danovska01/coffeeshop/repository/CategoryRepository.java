package com.danovska01.coffeeshop.repository;


import com.danovska01.coffeeshop.model.entity.Category;
import com.danovska01.coffeeshop.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum name);

}
