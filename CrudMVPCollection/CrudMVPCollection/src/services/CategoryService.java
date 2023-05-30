package services;

import models.Category;


import java.util.List;

public interface CategoryService {
    List<Category> getAllCategoryStatusActive();
    void Insert(Category category);

    Category getById(Integer id);

    void update(Category category,Integer id);

    void delete(Integer id);
}
