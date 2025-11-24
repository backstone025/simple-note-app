package com.backstone.simple_note_application.home;

import com.backstone.simple_note_application.note.Note;
import com.backstone.simple_note_application.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    NoteRepository noteRepository;

    @RequestMapping("home")
    public String home(ModelMap model) {
        String username = "backstone";
        List<Note> notes = noteRepository.findNoteByUsername(username);
        model.addAttribute("notes", notes);

        return "home";
    }
}
