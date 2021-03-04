package com.github.db;

import com.github.exceptions.DuplicatedException;
import com.github.exceptions.NotFoundException;

import java.util.Collection;

/**
 * @author Edgar Luque
 * @param <T> El objecto a persistir.
 * @param <S> El tipo de id.
 */
public interface DAO<T, S> {
    /**
     * Inserta el objecto.
     * @param object El objecto a insertar
     * @throws DuplicatedException Si el objecto esta
     * duplicado (e.g un constraint unique o primary key da error)
     */
    void insert(T object) throws DuplicatedException;

    /**
     * Obtiene un objecto por id.
     * @param id La id del objeto.
     * @return El objecto encontrado.
     * @throws NotFoundException Si el objecto no existe.
     */
    T getByID(S id) throws NotFoundException;
    Collection<T> getAll();
    void delete(S id);
    void deleteAll(Iterable<T> objects);
    void update(T object);
}
