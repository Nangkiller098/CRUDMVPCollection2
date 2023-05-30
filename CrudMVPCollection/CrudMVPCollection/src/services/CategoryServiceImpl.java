package services;

import models.Category;
import repositories.CategoryRepository;
import repositories.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> getAllCategoryStatusActive() {
        return categoryRepository.findAllCategory();
    }


    @Override
    public void Insert(Category category)
    {
        if (category.getName() == null || category.getName().equals("")) {
            System.out.println("category name is required");
        } else {

            categoryRepository.insert(category);
        }
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void update(Category category, Integer id) {
        categoryRepository.update(category,id);
    }

    @Override
    public void delete( Integer id) {categoryRepository.delete(id);

    }
}
