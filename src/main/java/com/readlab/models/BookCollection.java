package com.readlab.models;

import java.util.ArrayList;

public class BookCollection {
    private Book book;

    private String book_collection_id;
    private String book_collection_title;
    private String book_collection_description;

    private ArrayList<Book> books = new ArrayList<>();

    public BookCollection(Book book, String book_collection_id, String book_collection_title, String book_collection_description) {
        this.book_collection_id = book_collection_id;
        this.book_collection_title = book_collection_title;
        this.book_collection_description = book_collection_description;
    }

    public String getBook_collection_id() {
        return book_collection_id;
    }

    public void setBook_collection_id(String book_collection_id) {
        this.book_collection_id = book_collection_id;
    }

    public String getBook_collection_title() {
        return book_collection_title;
    }

    public void setBook_collection_title(String book_collection_title) {
        this.book_collection_title = book_collection_title;
    }

    public String getBook_collection_description() {
        return book_collection_description;
    }

    public void setBook_collection_description(String book_collection_description) {
        this.book_collection_description = book_collection_description;
    }

    public void getAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}