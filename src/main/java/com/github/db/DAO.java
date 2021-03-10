package com.github.db;

import com.github.exceptions.DatabaseException;
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
    void insert(T object) throws DuplicatedException, DatabaseException;

    /**
     * Obtiene un objecto por id.
     * @param id La id del objeto.
     * @return El objecto encontrado.
     * @throws NotFoundException Si el objecto no existe.
     */
    T getByID(S id) throws NotFoundException, DatabaseException;

    /**
     * Devuelve todos los clientes.
     * @return Una coleccion con todos los clientes.
     */
    Collection<T> getAll() throws DatabaseException;

    /**
     * Borra un objeto.
     * @param id La id del objeto
     */
    void delete(S id) throws DatabaseException;

    /**
     * Borra todos los objectos en la lista.
     * @param objects La lista de objectos a borrar
     */
    void deleteAll(Iterable<T> objects) throws DatabaseException;

    /**
     * Actualiza el objecto.
     * @param object El objeto a actualizar.
     */
    void update(T object) throws DatabaseException;
}
