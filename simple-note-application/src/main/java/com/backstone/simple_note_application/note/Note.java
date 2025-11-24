package com.backstone.simple_note_application.note;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Note {
    public Note() {
    }

    public Note(Long id, String username, String type, Integer state, String title, String metainfo, String context, LocalDate date) {
        this.id = id;
        this.username = username;
        this.type = type;
        this.state = state;
        this.title = title;
        this.metainfo = metainfo;
        this.context = context;
        this.date = date;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String type;
    private Integer state;
    private String title;
    private String metainfo;
    private String context;
    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMetainfo() {
        return metainfo;
    }

    public void setMetainfo(String metainfo) {
        this.metainfo = metainfo;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
