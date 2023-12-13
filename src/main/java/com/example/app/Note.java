package com.example.app;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;

    public Note() {}
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // можливість вручну встановити id для тестів
    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}
