package com.startjava.graduation.bookshelf;

import java.util.Arrays;

public class Bookshelf {
    private static final int QUANTITY_SHELVES = 10;
    private final Book[] books = new Book[QUANTITY_SHELVES];
    private int quantityBooks;
    private int lenShelf;

    public Book[] getBooks() {
        return Arrays.copyOf(books, (quantityBooks == 0 ? 0 : quantityBooks));
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

    public void add(Book book) {
        books[quantityBooks] = book;
        quantityBooks++;
        calculateLenShelf();
    }

    public boolean delete(String title) {
        int len = QUANTITY_SHELVES;
        for (int i = 0; i < len; i++) {
            if (books[i] != null && title.equals(books[i].getTitle())) {
                int deletedLen = books[i].getLenInfo();
                System.arraycopy(books, i + 1, books, i, len - 1 - i);
                books[len - 1] = null;
                if (deletedLen == lenShelf) {
                    lenShelf = 0;
                    calculateLenShelf();
                }
                quantityBooks--;
                return true;
            }
        }
        return false;
    }

    public Book search(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void clearShelf() {
        Arrays.fill(books, 0, quantityBooks, null);
        quantityBooks = 0;
    }

    private void calculateLenShelf() {
        for (Book book : books) {
            if (book != null) {
                if (book.getLenInfo() > lenShelf) lenShelf = book.getLenInfo();
            }
        }
    }
}
