package by.javaguru.hibernate.starter.dao;

import by.javaguru.hibernate.starter.entity.Ticket;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E> {
    boolean save(E e);
    boolean update(E e);
    boolean delete(K id);
    List<E> findAll();
    Optional<E> findById(K id);
}
