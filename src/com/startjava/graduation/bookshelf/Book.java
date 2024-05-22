package com.startjava.graduation.bookshelf;

public class Book {
    private static final int SUM_INDENT = 8;
    private final String author;
    private final String title;
    private final int year;
    private final int lenInform;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.lenInform = author.length() + title.length() + SUM_INDENT;
    }

    public String getTitle() {
        return title;
    }

    public int getLenInform() {
        return lenInform;
    }

    @Override
    public String toString() {
        return author + ", " + title + ", " + year;
    }
}
