package repositories;

import models.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAllCategory();
    void insert(Category category);
    Category findById(Integer id);
    void update(Category category,Integer id);
    void delete(Integer id);
}
