package services.Category;

import models.Category;
import repositories.Base.BaseRepositoryImpl;
import repositories.Category.CategoryRepository;
import repositories.Category.CategoryRepositoryImpl;

import java.util.List;

public class CategoryServiceImpl extends BaseRepositoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    @Override
    public List<Category> GetAllData() {
        return categoryRepository.FindAllData();
    }

    @Override
    public void Insert(Category category) {
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
    public void update(Category category, Integer id) {categoryRepository.update(category,id);}

    @Override
    public void delete(Integer id) {categoryRepository.delete(id);
    }
}
