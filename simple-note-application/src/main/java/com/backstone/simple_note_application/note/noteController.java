package com.backstone.simple_note_application.note;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class noteController {

    @RequestMapping("home")
    public String home() {
        return "home";
    }
}
