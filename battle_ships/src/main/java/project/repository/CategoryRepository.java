package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Category;
import project.model.entity.enums.CategoryNameEnum;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(CategoryNameEnum category);
}
