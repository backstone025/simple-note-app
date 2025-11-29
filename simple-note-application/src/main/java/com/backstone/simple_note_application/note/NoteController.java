package com.backstone.simple_note_application.note;

import com.backstone.simple_note_application.note.hierarchy.Category;
import com.backstone.simple_note_application.note.hierarchy.CategoryService;
import com.backstone.simple_note_application.note.hierarchy.CategoryTreeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NoteController {
    public NoteController(CategoryService categoryService, NoteService noteService) {
        this.categoryService = categoryService;
        this.noteService = noteService;
    }

    CategoryService categoryService;
    NoteService noteService;

    @RequestMapping("note-list")
    public String noteList(ModelMap model) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";
        Category root = categoryService.getCategoryRootByUsername(username);
        List<CategoryTreeDTO> categoryTree = categoryService.buildCategoryTree(root);
        List<Note> noteList = noteService.getByUsernameAndGroupid(username, root.getId());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categoryTree);

        model.addAttribute("categoryTree", json);
        model.addAttribute("noteList", noteList);
        return "noteList";
    }

    @RequestMapping("note-edit")
    public String noteEdit(ModelMap model, @RequestParam("noteId") Long noteId) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";

        Note note = noteService.getNoteByUsernameAndId(username, noteId);
        model.addAttribute("note", note);
        return "noteEdit";
    }
}
