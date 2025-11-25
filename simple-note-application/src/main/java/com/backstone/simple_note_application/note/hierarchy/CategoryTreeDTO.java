package com.backstone.simple_note_application.note.hierarchy;

import java.util.List;

public class CategoryTreeDTO {
    public CategoryTreeDTO() {
    }

    public CategoryTreeDTO(Long id, String name, List<CategoryTreeDTO> children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    private Long id;
    private String name;
    private List<CategoryTreeDTO> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryTreeDTO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryTreeDTO> children) {
        this.children = children;
    }
}
