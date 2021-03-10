package com.github.db;

import com.github.Platform;
import com.github.Videogame;
import com.github.exceptions.DuplicatedException;
import com.github.exceptions.NotFoundException;

import java.sql.Connection;

import java.util.Collection;

/**
 * La implementacion del videogame DAO para sql.
 */
public class VideogameJDBCDAO implements VideogameDAO {
    private Connection connection;

    public VideogameJDBCDAO(ConexioJDBC connection) {
        this.connection = connection.getConnection();
    }

    @Override
    public void insert(Videogame object) throws DuplicatedException {

    }

    @Override
    public Videogame getByID(Integer id) throws NotFoundException {
        return null;
    }

    @Override
    public Collection<Videogame> getAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteAll(Iterable<Videogame> objects) {

    }

    @Override
    public void update(Videogame object) {

    }

    @Override
    public Collection<Videogame> getByName(String name) {
        return null;
    }

    @Override
    public Collection<Videogame> getByPlatform(Platform platform) {
        return null;
    }
}
