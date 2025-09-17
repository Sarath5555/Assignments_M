package com.example.repository;

import com.example.entity.Book;

import java.util.List;

public interface BookRepository {
    Book add(Book book);
    Book update(Book book);
    void deleteById(int id);
    void deleteByTitle(String title);
    Book findById(int id);
    List<Book> findByTitle(String title);
    List<Book> listAll();
}
