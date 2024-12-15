package com.readlab.models;

public class ReadPage {
    private Book readpage_current_book;
    private int readpage_current_page;
    private double readpage_font_size;

    public ReadPage (Book book, int page, double font_size) {
        this.readpage_current_book = book;
        this.readpage_current_page = page;
        this.readpage_font_size = font_size;
    }
    public int getCurrentPage() {
        return readpage_current_page;
    }
    public void nextPage() {
        readpage_current_page++;
    }
    public void previousPage() {
        readpage_current_page--;
    }
    public void navigateToPage(int page) {
        readpage_current_page = page;
    }
    public void setFontSize(double font_size) {
        readpage_font_size = font_size;
    }
}
