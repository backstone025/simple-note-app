package com.backstone.simple_note_application.note;

import com.backstone.simple_note_application.note.hierarchy.CategoryService;
import com.backstone.simple_note_application.note.hierarchy.CategoryTreeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NoteController {
    public NoteController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    CategoryService categoryService;

    @RequestMapping("note-list")
    public String noteList(ModelMap model) throws Exception {
        List<CategoryTreeDTO> categoryTree = categoryService.buildCategoryEntireTree();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categoryTree);

        model.addAttribute("categoryTree", json);
        return "noteList";
    }
}
