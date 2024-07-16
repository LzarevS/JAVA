package springbootapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootapplication.model.Category;
import springbootapplication.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setTitle(updatedCategory.getTitle());
            return categoryRepository.save(category);
        } else {
            return null;
        }
    }

    public boolean deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            categoryRepository.deleteById(id);
            return true; // Успешно удалено
        } else {
            return false; // Категория с указанным id не найдена
        }
    }

}
