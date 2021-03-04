package com.github.db;

import java.util.Collection;

/**
 * @author Edgar Luque
 * @param <T> El objecto a persistir.
 * @param <S> El tipo de id.
 */
public interface DAO<T, S> {
    void insert(T object);
    T getByID(S id);
    Collection<T> getAll();
    void delete(S id);
    void deleteAll(Iterable<T> objects);
    void update(T object);
}
