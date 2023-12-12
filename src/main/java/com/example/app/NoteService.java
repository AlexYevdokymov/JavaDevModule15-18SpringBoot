package com.example.app;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private final Map<Long, Note> notes = new HashMap<>();
    public List<Note> listAll() {
        return new ArrayList<Note>(notes.values());
    }

    public Note add(Note note) {
        long id;
        if (note.getId() == 0) {
            id = new Random().nextLong();
            note.setId(id);
        } else id = note.getId();
        notes.put(id,note);
    return note;
    }

    public void deleteById (long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        } else throw new NullPointerException("Couldn't find a note with this id " + id);
    }

    public void update(Note note) {
        long noteId = note.getId();
        if (notes.containsKey(noteId)) {
            notes.put(noteId, note);
        } else throw new NullPointerException("Couldn't find a note with this id " + noteId);
    }

    public Note getById (long id) {
        if (notes.containsKey(id)) {
            return notes.get(id);
        } else throw new NullPointerException("Couldn't find a note with this id " + id);
    }

    public NoteService () {
        add(new Note("First note", "Content in first note"));
        add(new Note("Second note", "Content in second note"));
        add(new Note("Third note", "Content in third note"));
    }
}
