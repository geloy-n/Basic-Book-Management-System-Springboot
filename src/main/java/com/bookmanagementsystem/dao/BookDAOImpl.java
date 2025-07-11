package com.bookmanagementsystem.dao;

import com.bookmanagementsystem.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private final EntityManager entityManager;

    public BookDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery("From Book", Book.class);
        return query.getResultList();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        TypedQuery<Book> query = entityManager.createQuery("from Book where author=:theAuthor", Book.class);
        query.setParameter("theAuthor", author);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Book book) {
        entityManager.merge(book);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }
}
