package com.example.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/note")
public class RestNoteController {
    private final NoteService noteService;

    public RestNoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public List<Note> getNotes() {
        return noteService.listAll();
    }
    @GetMapping("/get")
    public Note getNoteById(@RequestParam long id) {
        return noteService.getById(id);
    }
    @PostMapping("/delete")
    public void deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
    }
    @PostMapping("/edit")
    public void postEditedNote(@RequestBody Note updatedNote) {
        noteService.update(updatedNote);
    }
    @PostMapping("/add")
    public void postNote(@RequestBody Note note) {
        noteService.add(note);
    }
}
