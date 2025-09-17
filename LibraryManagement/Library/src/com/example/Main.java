package com.example;

import com.example.entity.Book;
import com.example.repository.*;
import com.example.service.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BookRepository bookRepo = new BookRepositoryImpl();
        BookService bookService = new BookServiceImpl(bookRepo);

        int mainChoice;
        do {
            System.out.println("\n=== LIBRARY MANAGEMENT ===");
            System.out.println("1. Book");
            System.out.println("2. User");
            System.out.println("3. Loan Record");
            System.out.println("99. Exit");
            System.out.print("Select option: ");
            mainChoice = Integer.parseInt(sc.nextLine());

            switch (mainChoice) {
                case 1 -> bookMenu(bookService);
                case 99 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option");
            }
        } while (mainChoice != 99);

        sc.close();
    }

    private static void bookMenu(BookService bookService) {
        int choice;
        do {
            System.out.println("\n--- BOOK MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book Details");
            System.out.println("3. Delete Book By Id");
            System.out.println("4. Delete Book By Name");
            System.out.println("5. Search Book By Id");
            System.out.println("6. Search Book By Title");
            System.out.println("7. List All Books");
            System.out.println("0. Back");
            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    Book b = readBookInputForAdd();
                    bookService.addBook(b);
                    System.out.println("Book added: " + b);
                }
                case 2 -> {
                    System.out.print("Enter book id to update: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Book existing = bookService.findById(id);
                    if (existing == null) {
                        System.out.println("Book not found.");
                        break;
                    }
                    System.out.println("Existing: " + existing);
                    System.out.println("Enter new title (leave empty to keep): ");
                    String title = sc.nextLine();
                    if (!title.isBlank()) existing.setTitle(title);
                    System.out.println("Enter new price (-1 to keep): ");
                    double price = Double.parseDouble(sc.nextLine());
                    if (price >= 0) existing.setPrice(price);
                    System.out.println("Enter new quantity (-1 to keep): ");
                    int q = Integer.parseInt(sc.nextLine());
                    if (q >= 0) existing.setQuantity(q);
                    bookService.updateBook(existing);
                    System.out.println("Updated: " + existing);
                }
                case 3 -> {
                    System.out.print("Enter book id to delete: ");
                    int id = Integer.parseInt(sc.nextLine());
                    bookService.deleteById(id);
                }
                case 4 -> {
                    System.out.print("Enter book title to delete: ");
                    String title = sc.nextLine();
                    bookService.deleteByTitle(title);
                }
                case 5 -> {
                    System.out.print("Enter book id to search: ");
                    int id = Integer.parseInt(sc.nextLine());
                    Book found = bookService.findById(id);
                    if (found != null) {
                        System.out.println(found);
                    }
                }
                case 6 -> {
                    System.out.print("Enter book title to search: ");
                    String title = sc.nextLine();
                    List<Book> found = bookService.findByTitle(title);
                    if (!found.isEmpty()) {
                        found.forEach(System.out::println);
                    }
                }
                case 7 -> {
                    List<Book> allBooks = bookService.listAll();
                    if (!allBooks.isEmpty()) {
                        allBooks.forEach(System.out::println);
                    }
                }
                case 0 -> System.out.println("Back to main menu");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 0);
    }

    private static Book readBookInputForAdd() {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Publisher: ");
        String publisher = sc.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(sc.nextLine());
        return new Book(0, title, desc, price, author, publisher, qty);
    }
}
