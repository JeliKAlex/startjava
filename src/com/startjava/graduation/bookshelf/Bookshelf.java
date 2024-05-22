package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int QUANTITY_SHELVES = 10;
    private final Book[] books = new Book[QUANTITY_SHELVES];
    private int quantityBooks;
    private int lenShelf;

    public Book[] getBooks() {
        return books;
    }

    public int getQuantityBooks() {
        return quantityBooks;
    }

    public int getFreeShelves() {
        return QUANTITY_SHELVES - quantityBooks;
    }

    public int getLenShelf() {
        return lenShelf;
    }

    public void addBook(Book book) {
        books[quantityBooks] = book;
        quantityBooks++;
        calculateLenShelf();
    }

    private void calculateLenShelf() {
        for (Book book : books) {
            if (book != null) {
                if (book.getLenInform() > lenShelf) lenShelf = book.getLenInform();
            }
        }
    }

    public int deleteBook(String name) {
        int len = QUANTITY_SHELVES;
        for (int i = 0; i < len; i++) {
            if (name.equals(books[i].getTitle())) {
                int deletedLen = books[i].getLenInform();
                if (i == 0) {
                    System.arraycopy(books, 1, books, 0, len - 1);
                } else if (i < len - 1) {
                    System.arraycopy(books, 0, books, 0, i);
                    System.arraycopy(books, i + 1, books, i, len - i - 1);
                }
                books[len - 1] = null;
                if (deletedLen == lenShelf) {
                    calculateLenShelf();
                }
                quantityBooks--;
                return 1;
            }
        }
        return 0;
    }

    public int searchBook(String name) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].getTitle().equals(name)) {
                return i + 1;
            }
        }
        return 0;
    }

    public void clearShelf() {
        Arrays.fill(books, 0, quantityBooks, null);
        quantityBooks = 0;
    }
}
