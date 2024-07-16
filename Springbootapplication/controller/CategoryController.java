package springbootapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springbootapplication.model.Category;
import springbootapplication.service.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            String errorMessage = "Категория с id " + id + " не найдена.";
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestParam Long id, @RequestBody Category updatedCategory) {
        Category existingCategory = categoryService.getCategoryById(id);
        if (existingCategory == null) {
            return ResponseEntity.notFound().build();
        }

        existingCategory.setTitle(updatedCategory.getTitle());

        Category updated = categoryService.saveCategory(existingCategory);
        return ResponseEntity.ok(updated);
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.saveCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategory(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            String errorMessage = "Категория с id " + id + " не найдена.";
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", errorMessage);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
