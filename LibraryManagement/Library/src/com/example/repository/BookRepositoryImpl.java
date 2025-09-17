package com.example.repository;

import com.example.entity.Book;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements BookRepository {
    private Map<Integer, Book> Bookstore = new HashMap<>();
    private AtomicInteger idGen = new AtomicInteger(1);

    @Override
    public Book add(Book book) {
        int id = idGen.getAndIncrement();
        book.setId(id);
        Bookstore.put(id, book);
        return book;
    }

    @Override
    public Book update(Book book) {
        if (!Bookstore.containsKey(book.getId())) {
            System.out.println("Book not found with id " + book.getId());
            return null;
        }
        Bookstore.put(book.getId(), book);
        return book;
    }

    @Override
    public void deleteById(int id) {
        if (Bookstore.remove(id) == null) {
            System.out.println("Book not found with id " + id);
        }
    }

    @Override
    public void deleteByTitle(String title) {
        List<Integer> ids = Bookstore.values().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .map(Book::getId)
                .collect(Collectors.toList());
        if (ids.isEmpty()) {
            System.out.println("No books found with title " + title);
            return;
        }
        ids.forEach(Bookstore::remove);
    }

    @Override
    public Book findById(int id) {
        Book b = Bookstore.get(id);
        if (b == null) {
            System.out.println("Book not found with id " + id);
        }
        return b;
    }

    @Override
    public List<Book> findByTitle(String title) {
        List<Book> books = Bookstore.values().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        if (books.isEmpty()) {
            System.out.println("No books found with title " + title);
        }
        return books;
    }

    @Override
    public List<Book> listAll() {
        if (Bookstore.isEmpty()) {
            System.out.println("No books available in the store.");
        }
        return new ArrayList<>(Bookstore.values());
    }
}
