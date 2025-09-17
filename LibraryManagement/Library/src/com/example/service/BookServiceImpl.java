package com.example.service;

import com.example.entity.Book;
import com.example.repository.BookRepository;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookRepository repo;

    public BookServiceImpl(BookRepository repo) { this.repo = repo; }

    @Override
    public Book addBook(Book book) { return repo.add(book); }

    @Override
    public Book updateBook(Book book) { return repo.update(book); }

    @Override
    public void deleteById(int id) { repo.deleteById(id); }

    @Override
    public void deleteByTitle(String title) { repo.deleteByTitle(title); }

    @Override
    public Book findById(int id) { return repo.findById(id); }

    @Override
    public List<Book> findByTitle(String title) { return repo.findByTitle(title); }

    @Override
    public List<Book> listAll() { return repo.listAll(); }
}

