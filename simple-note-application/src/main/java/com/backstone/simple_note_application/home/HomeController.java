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
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @Autowired
    NoteRepository noteRepository;

    HomeService homeService;

    @RequestMapping("home")
    public String home(ModelMap model) {
        // FIXME Remind to make usable for each user. (do not fix username as "backstone".)
        String username = "backstone";
        List<Note> notes = homeService.findRecentNotes("backstone",5);
        model.addAttribute("notes", notes);
        return "home";
    }
}
