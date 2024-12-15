package com.readlab.models;

public class Note {
    private Book book;
    private User user;
    private int note_id;
    private int note_page;
    private String note;

    public Note(Book book, User user, int note_id, int note_page, String note) {
        this.book = book;
        this.user = user;
        this.note_id = note_id;
        this.note_page = note_page;
        this.note = note;
    }

    public void PrintNote(){
        System.out.println("Book Name : " + book.getBook_title());
        System.out.println("User : " + user.getUser_id());
        System.out.println("Note id : " + this.note_id);
        System.out.println("Note page : " + this.note_page);
        System.out.println("isi Note : " + this.note);
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public int getNote_page() {
        return note_page;
    }

    public void setNote_page(int note_page) {
        this.note_page = note_page;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
