package com.bookmanagementsystem.dao;

import com.bookmanagementsystem.entity.Book;

import java.util.List;

public interface BookDAO {
    void save(Book book);

    Book findById(int id);

    List<Book> findAll();

    List<Book> findByAuthor(String author);

    void update(Book book);

    void delete(int id);
}
