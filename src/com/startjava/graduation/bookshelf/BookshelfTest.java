package com.startjava.graduation.bookshelf;

import java.util.Scanner;

public class BookshelfTest {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        start(bookshelf);
    }

    private static void start(Bookshelf bookshelf) {
        String input = "";
        do {
            showShelf(bookshelf.getQuantityBooks(), bookshelf.getFreeShelves(),
                    bookshelf.getBooks(), bookshelf.getLenShelf());
            System.out.println("""
                    \n1. Добавить книгу
                    2. Удалить книгу
                    3. Найти книгу
                    4. Получить кол-во книг
                    5. Получить кол-во свободных полок
                    6. Очистить шкаф
                    7. Завершить
                    """);
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1 -> add(bookshelf);
                case 2 -> delete(bookshelf);
                case 3 -> search(bookshelf);
                case 4 -> System.out.println("Количество книг в шкафу: " + bookshelf.getQuantityBooks());
                case 5 -> System.out.println("Количество свободных полок в шкафу: " +
                        bookshelf.getFreeShelves());
                case 6 -> {
                    bookshelf.clearShelf();
                    System.out.println("Шкаф очищен!");
                }
                case 7 -> input = "7";
                default -> System.out.println("Некорректный ввод");
            }
            System.out.println("\nДля продолжения нажмите Enter\n");
            scan.nextLine();
        } while (!input.equals("7"));
    }

    private static void showShelf(int quantityBooks, int freeShelves, Book[] books, int lenShelf) {
        if (quantityBooks == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
        } else {
            System.out.println("В шкафу книг - " + quantityBooks + ", свободно полок - " + freeShelves);
            for (Book book : books) {
                if (book != null) {
                    System.out.printf("|%s%s|\n", book, " ".repeat(lenShelf - book.getLenInfo()));
                    System.out.printf("|%s|\n", "-".repeat(lenShelf));
                }
            }
            System.out.printf("|%s|\n", " ".repeat(lenShelf));
        }
    }

    private static void add(Bookshelf bookshelf) {
        System.out.println("Введите автора книги: ");
        String author = scan.nextLine();
        String name = inputTitle();
        System.out.println("Введите год издания книги: ");
        int releaseYear = scan.nextInt();
        bookshelf.add(new Book(author, name, releaseYear));
        System.out.println("Книга успешно добавлена!");
        scan.nextLine();
    }

    private static String inputTitle() {
        System.out.println("Введите название книги: ");
        return scan.nextLine();
    }

    private static void delete(Bookshelf bookshelf) {
        String title = inputTitle();
        if (bookshelf.delete(title)) {
            System.out.println("Книга успешно удалена!");
        } else {
            System.out.println("Книга не найдена!");
        }
    }

    private static void search(Bookshelf bookshelf) {
        String title = inputTitle();
        if (bookshelf.search(title) != null) {
            System.out.println("Книга " + title + " найдена!");
        } else {
            System.out.println("Книга не найдена!");
        }
    }
}
