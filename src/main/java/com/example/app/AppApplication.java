package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);

		// тестування
//		NoteService noteService = new NoteService();
//
//		noteService.add(new Note("First note", "Content in first note"));
//		noteService.add(new Note(45,"Bla bla", "Bla bla bla"));
//		noteService.add(new Note(10,"Bla bla", "Bla bla bla"));
//		noteService.add(new Note(12,"Bla bla", "Bla bla bla"));
//		noteService.add(new Note(15,"Bla bla", "Bla bla bla"));
//		System.out.println(noteService.add(new Note(17, "Bla bla", "Bla bla bla")));
//		noteService.getById(12);
//		System.out.println("noteService.listAll() = " + noteService.listAll());
//		noteService.deleteById(10);
//		noteService.update(new Note(15,"Updated Bla bla", " Updated Bla bla bla"));
//		System.out.println("noteService.listAll() = " + noteService.listAll());
	}

}
