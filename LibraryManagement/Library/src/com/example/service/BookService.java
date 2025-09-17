package com.example.service;

import com.example.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteById(int id);
    void deleteByTitle(String title);
    Book findById(int id);
    List<Book> findByTitle(String title);
    List<Book> listAll();
}
