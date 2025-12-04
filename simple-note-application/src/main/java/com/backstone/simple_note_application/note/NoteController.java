package com.backstone.simple_note_application.note;

import com.backstone.simple_note_application.note.hierarchy.Category;
import com.backstone.simple_note_application.note.hierarchy.CategoryService;
import com.backstone.simple_note_application.note.hierarchy.CategoryTreeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String noteList(ModelMap model, @RequestParam("nodeId") Long nodeId) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";
        Category root = categoryService.getCategoryRootByUsername(username);

        List<CategoryTreeDTO> categoryTree = categoryService.buildCategoryTree(root);
        List<Note> noteList = noteService.getByUsernameAndGroupid(username, nodeId);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categoryTree);

        model.addAttribute("categoryTree", json);
        model.addAttribute("noteList", noteList);
        model.addAttribute("nodeId", nodeId);
        return "noteList";
    }

    @RequestMapping("note-read")
    public String noteRead(ModelMap model, @RequestParam("noteId") Long noteId) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";

        Note note = noteService.getNoteByUsernameAndId(username, noteId);
        String editPage = "noteRead";
        model.addAttribute("note", note);
        return editPage;
    }

    @RequestMapping(value = "note-edit", method = RequestMethod.GET)
    public String noteEditGet(ModelMap model, @RequestParam("noteId") Long noteId) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";

        Note note = noteService.getNoteByUsernameAndId(username, noteId);
        String editPage = noteService.getNoteEditPageByType(note);

        model.addAttribute("note", note);
        return editPage;
    }

    @RequestMapping(value = "note-edit", method = RequestMethod.POST)
    public String noteEditPost(@ModelAttribute("note") Note note) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";

        Long groupid = note.getGroupid();
        String noteEdit = "redirect:note-list?nodeId=" + groupid;
        ;

        if (note.getState() != 1) {
            note.setState(1);
        }

        noteService.updateNote(note);
        return noteEdit;
    }

    @RequestMapping("note-delete")
    public String noteDelete(@RequestParam("noteId") Long noteId, @RequestParam("nodeId") Long nodeId) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";

        Note note = noteService.getNoteByUsernameAndId(username, noteId);

        noteService.deleteNote(note);
        return "redirect:note-list?nodeId=" + nodeId;
    }

    @RequestMapping("note-add")
    public String noteAdd(ModelMap model, @RequestParam("nodeId") Long nodeId) throws Exception {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";

        Note note = noteService.createNote(username, nodeId);
        noteService.updateNote(note);
        note.setTitle("empty note " + note.getId());
        noteService.updateNote(note);

        Category root = categoryService.getCategoryRootByUsername(username);

        List<CategoryTreeDTO> categoryTree = categoryService.buildCategoryTree(root);
        List<Note> noteList = noteService.getByUsernameAndGroupid(username, nodeId);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(categoryTree);

        model.addAttribute("categoryTree", json);
        model.addAttribute("noteList", noteList);
        model.addAttribute("nodeId", nodeId);
        return "noteList";
    }
}
