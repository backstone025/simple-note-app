package com.backstone.simple_note_application.note.hierarchy;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private CategoryRepository categoryRepository;

    public Category getCategoryRootByUsername(String username) {
        return categoryRepository.findrootCategory(username);
    }

    public List<CategoryTreeDTO> buildCategoryTree(Category parent) {
        List<CategoryTreeDTO> categoryTree = new ArrayList<>();
        categoryTree.add(convertToCategoryTreeDTO(parent));
        return categoryTree;
    }

    public CategoryTreeDTO convertToCategoryTreeDTO(Category category) {
        if(category == null) {
            return null;
        }

        List<CategoryTreeDTO> children = category.getChildren().stream()
                .map(this::convertToCategoryTreeDTO)
                .collect(Collectors.toList());

        CategoryTreeDTO dto = new CategoryTreeDTO(
                category.getId(),
                category.getName(),
                children
        );
        return dto;
    }
}
