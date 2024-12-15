package com.readlab.models;

public class Bookmark {
    private Book book;
    private int bookmark_id;
    private int bookmark_page;

    public Bookmark(Book book, int bookmark_id, int bookmark_page) {
        this.book = book;
        this.bookmark_id = bookmark_id;
        this.bookmark_page = bookmark_page;
    }

    public void PrintBookmark(){
        System.out.println("Book Name : " + book.getBook_title());
        System.out.println("Bookmark id : " + this.bookmark_id);
        System.out.println("Bookmark page : " + this.bookmark_page);
    }

    public int getBookmark_id() {
        return bookmark_id;
    }

    public void setBookmark_id(int bookmark_id) {
        this.bookmark_id = bookmark_id;
    }

    public int getBookmark_page() {
        return bookmark_page;
    }

    public void setBookmark_page(int bookmark_page) {
        this.bookmark_page = bookmark_page;
    }


}
