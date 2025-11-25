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

    public List<CategoryTreeDTO> buildCategoryEntireTree() {
        Category root = categoryRepository.findrootCategory();

        if (root == null) {
            return new ArrayList<>();
        }else {
            return root.getChildren().stream()
                    .map(this::convertToCategoryTreeDTO)
                    .collect(Collectors.toList());
        }
    }

    public List<CategoryTreeDTO> buildCategorySubTree(Category parent) {
        if (parent == null) {
            return new ArrayList<>();
        }else {
            return parent.getChildren().stream()
                    .map(this::convertToCategoryTreeDTO)
                    .collect(Collectors.toList());
        }
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
