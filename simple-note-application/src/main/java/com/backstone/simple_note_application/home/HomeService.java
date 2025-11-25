package com.backstone.simple_note_application.home;

import com.backstone.simple_note_application.note.Note;
import com.backstone.simple_note_application.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    @Autowired
    NoteRepository noteRepository;

    public List<Note> findRecentNotes(String username, int num){
        PageRequest pageRequest = PageRequest.of(0, num, Sort.by(Sort.Direction.DESC, "date"));
        return noteRepository.findNoteByUsername(username, pageRequest);
    }
}
