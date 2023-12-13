package com.example.app;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository repository;
    public List<Note> listAll() {
        return repository.findAll();
    }

    public void add(Note note) {
        repository.save(note);
    }

    public void deleteById (long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        } else throw new NullPointerException("Couldn't find a note with this id " + id);
    }

    public void update(Note note) {
        long noteId = note.getId();
        if (repository.existsById(noteId)) {
            repository.save(note);
        } else throw new NullPointerException("Couldn't find a note with this id " + noteId);
    }

    public Note getById (long id) {
        Note result = repository.findById(id).orElse(null);
        if (result != null) return result;
        else throw new NullPointerException("Couldn't find a note with this id " + id);
    }

//    public NoteService () {
//        add(new Note("First note", "Content in first note"));
//        add(new Note("Second note", "Content in second note"));
//        add(new Note("Third note", "Content in third note"));
//    }
}
