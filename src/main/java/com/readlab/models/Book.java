package com.readlab.models;

import java.util.ArrayList;
import java.util.Date;

public class Book {
    private String book_id;
    private String book_isbn;
    private String book_title;
    private String book_author;
    private String book_genre;
    private int book_total_page;
    private Date book_date_release;

    private ArrayList<Note> Notelist = new ArrayList<Note>();
    private ArrayList <Bookmark> Bookmarklist = new ArrayList<Bookmark>();

    public Book(String book_id, String book_title, String book_author, String book_genre) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_genre = book_genre;
    }
    //Method untuk menambahkan Note
    public void TambahNote(User user, int hal, String note){
        if (Notelist.isEmpty()){
            Note x = new Note(this,user,user.getUser_id() * 1000 + 400, hal, note);
            this.Notelist.add(x);
        }else{
            Note x = new Note(this,user,Notelist.get(Notelist.size()-1).getNote_id() + 1,hal,note);
            this.Notelist.add(x);
        }
    }
    //Method untuk menambahkan Bookmark
    public void TambahBookmark(User user, int hal, String note){
        if (Bookmarklist.isEmpty()){
            Bookmark x = new Bookmark(this,user.getUser_id() * 1000 + 800 , hal);
            this.Bookmarklist.add(x);
        }else{
            Bookmark x = new Bookmark(this,Bookmarklist.get(Bookmarklist.size()-1).getBookmark_id() + 1,hal);
            this.Bookmarklist.add(x);
        }
    }
    //Method untuk menghapus Bookmark
    public void DeleteBookmark(int idBookmark){
        boolean found = false;
        if (Bookmarklist.isEmpty()){
            System.out.println("Buku ini tidak memiliki Bookmark.");
        }else{
            for (int i = 0; i < Bookmarklist.size(); i++) {
                if(Bookmarklist.get(i).getBookmark_id()==(idBookmark)){
                    found = true;
                    Bookmarklist.remove(i);
                    System.out.println("Bookmark berhasil dihapus");
                }
            }
            if (!found){
                System.out.println("Bookmark id tidak ditemukan");
            }
        }
    }

    //Method untuk menghapus Note
    public void DeleteNote(int idNote){
        boolean found = false;
        if (Notelist.isEmpty()){
            System.out.println("Buku ini tidak memiliki Note.");
        }else{
            for (int i = 0; i < Notelist.size(); i++) {
                if(Notelist.get(i).getNote_id()==(idNote)){
                    found = true;
                    Notelist.remove(i);
                    System.out.println("Note berhasil dihapus");
                }
            }
            if (!found){
                System.out.println("Note id tidak ditemukan");
            }
        }
    }

    //method untuk print semua Note
    public void printallNote(){
        if(Notelist.isEmpty()){
            System.out.println("Belum ada Note.");
        }else{
            System.out.println("Note: ");
            for (int i = 0 ; i < Notelist.size() ; i++){
                Notelist.get(i).PrintNote();
            }
        }
    }

    //method untuk print semua Bookmark
    public void printallBookmark(){
        if(Bookmarklist.isEmpty()){
            System.out.println("Belum ada Bookmark.");
        }else{
            System.out.println("Bookmark: ");
            for (int i = 0 ; i < Bookmarklist.size() ; i++){
                Bookmarklist.get(i).PrintBookmark();
            }
        }
    }

    // Method untuk menampilkan detail buku
    public void getBookDetails() {
        System.out.println("Book ID: " + book_id);
        System.out.println("Title: " + book_title);
        System.out.println("Author: " + book_author);
        System.out.println("Genre: " + book_genre);
        System.out.println("Total Pages: " + book_total_page);
        System.out.println("Release Date: " + book_date_release);
    }

    // Metode untuk mendownload buku
    public void downloadBook() {
        try {
            System.out.println("Downloading the book: " + book_title);
        } catch (Exception e) {
            System.out.println("Error saat mendownload buku" );
        }
    }

    // Metode untuk membaca buku
    public void readBook() {
        try {
            System.out.println("Reading book: " + book_title);
        } catch (Exception e) {
            System.out.println("Error saat membaca buku " );
        }
    }

    // Getter dan setter
    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public String getBook_genre() {
        return book_genre;
    }

    public void setBook_genre(String book_genre) {
        this.book_genre = book_genre;
    }

    public int getBook_total_page() {
        return book_total_page;
    }

    public void setBook_total_page(int book_total_page) {
        this.book_total_page = book_total_page;
    }

    public Date getBook_date_release() {
        return book_date_release;
    }

    public void setBook_date_release(Date book_date_release) {
        this.book_date_release = book_date_release;
    }
}