package com.backstone.simple_note_application.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoteController {
    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Autowired
    NoteRepository noteRepository;

    @RequestMapping("note-list")
    public String noteList() {
        return "noteList";
    }
}
