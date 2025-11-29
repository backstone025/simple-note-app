package com.backstone.simple_note_application.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Autowired
    NoteRepository noteRepository;

    public List<Note> getByUsernameAndGroupid(String username, Long groupid) {
        return noteRepository.findNoteByUsernameAndGroupidOrderByDateDesc(username, groupid);
    }

    public Note getNoteByUsernameAndId(String username, Long id) {
        return noteRepository.findNoteByUsernameAndId(username, id);
    }
}
