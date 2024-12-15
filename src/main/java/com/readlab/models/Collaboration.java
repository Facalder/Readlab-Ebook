package com.readlab.models;

import java.util.ArrayList;

public class Collaboration {
    private String id;
    private Book book;
    private ArrayList<User> authors = new ArrayList<User>();

    public Collaboration(String id, Book book) {
        this.id = id;
        this.book = book;
    }
    public String getId() {
        return id;
    }
    public ArrayList<User> getAuthors() {
        return authors;
    }
    public void addAuthor(User author) {
        authors.add(author);
    }
    public void removeAuthor(User author) {
        authors.remove(author);
    }
}
