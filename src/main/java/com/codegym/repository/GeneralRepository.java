package com.codegym.repository;

import java.util.List;

public interface GeneralRepository<T> {
    List<T> findAll();

    void save(T product);

    void update(int id, T product);

    void remove(int id);

    T findById(int id);

    T findByName(String name);

}
