package com.startjava.graduation.bookshelf;

public class Book {
    private final String author;
    private final String title;
    private final int releaseYear;
    private final int lenInfo;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.releaseYear = year;
        lenInfo = toString().length();
    }

    public String getTitle() {
        return title;
    }

    public int getLenInfo() {
        return lenInfo;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + releaseYear;
    }
}
