package com.danovska01.battleships.repositories;

import com.danovska01.battleships.models.Category;
import com.danovska01.battleships.models.ShipType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(ShipType name);
}
