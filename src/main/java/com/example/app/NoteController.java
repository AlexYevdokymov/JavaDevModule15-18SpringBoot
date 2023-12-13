package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String getNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "list";
    }
    @PostMapping("/delete")
    public String deleteNote(@RequestParam long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }
    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String postEditedNote(@ModelAttribute Note updatedNote) {
        noteService.update(updatedNote);
        return "redirect:/note/list";
    }
    @GetMapping("/add")
    public String createNote(Model model) {
        model.addAttribute("note", new Note());
        return "add";
    }

    @PostMapping("/add")
    public String postNote(@ModelAttribute Note note) {
        noteService.add(note);
        return "redirect:/note/list"; // Перенаправлення на сторінку зі списком нотаток
    }
}
