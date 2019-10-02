package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;

    /**
     * Decided not to allow users to enter dates and times.  Dates and times are
     * entered as a timestamp the moment the message is created.
     */
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    //private LocalDateTime now = LocalDateTime.now();
    private LocalDateTime now;
    public String dateToString() {
        return dtf.format(now);
    }

    public Message() {
        now = LocalDateTime.now();
    }

    public Message(String title, String description) {
        this.title = title;
        this.description = description;
        now = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
