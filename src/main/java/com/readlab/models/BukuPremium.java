package com.readlab.models;

public class BukuPremium extends Book {
    private int bukuPremium_harga;
    private boolean bukuPremium_purchasedStatus;

    public BukuPremium(String book_id, String book_title, String book_author, String book_genre, int bukuPremium_Harga) {
        super(book_id, book_title, book_author, book_genre);
        this.bukuPremium_harga = bukuPremium_Harga;
        this.bukuPremium_purchasedStatus = false; // default status belum dibeli
    }

    // Metode untuk membeli buku
    public void purchaseBook() {
        try {
            if (!bukuPremium_purchasedStatus) {
                bukuPremium_purchasedStatus = true;
                System.out.println("You have successfully purchased the book: " + getBook_title());
            } else {
                throw new IllegalStateException("This book has already been purchased.");
            }
        } catch (Exception e) {
            System.err.println("Error saat membeli buku: " + e.getMessage());
        }
    }

    @Override
    public void readBook() {
        try {
            if (bukuPremium_purchasedStatus) {
                System.out.println("Reading premium book: " + getBook_title());
            } else {
                throw new IllegalStateException("You need to purchase this book first.");
            }
        } catch (Exception e) {
            System.err.println("Error saat membaca buku: " + e.getMessage());
        }
    }

    // Getter dan setter
    public int getBukuPremium_harga() {
        return bukuPremium_harga;
    }

    public void setBukuPremium_harga(int bukuPremium_harga) {
        this.bukuPremium_harga = bukuPremium_harga;
    }

    public boolean isBukuPremium_purchasedStatus() {
        return bukuPremium_purchasedStatus;
    }

    public void setBukuPremium_purchasedStatus(boolean bukuPremium_purchasedStatus) {
        this.bukuPremium_purchasedStatus = bukuPremium_purchasedStatus;
    }
}
