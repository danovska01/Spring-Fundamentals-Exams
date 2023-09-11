package com.danovska01.battleships.seeders;

import com.danovska01.battleships.models.ShipType;
import com.danovska01.battleships.repositories.CategoryRepository;
import com.danovska01.battleships.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategorySeeder implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategorySeeder(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(ShipType.values())
                .map(Category::new)
                .collect(Collectors.toList());

            this.categoryRepository.saveAll(categories);
            // n + 1 queries problem
        }
    }
}
