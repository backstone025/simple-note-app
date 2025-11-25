package com.backstone.simple_note_application.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Autowired
    NoteRepository noteRepository;
}
