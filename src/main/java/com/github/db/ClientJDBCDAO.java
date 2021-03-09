package com.github.db;

import com.github.Client;

import java.sql.Connection;
import java.util.Collection;

/**
 * La implementacion del cliente DAO para sql.
 */
public class ClientJDBCDAO implements ClientDAO {
    private Connection connection;

    public ClientJDBCDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Client object) {

    }

    @Override
    public Client getByID(Integer id) {
        return null;
    }

    @Override
    public Collection<Client> getAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteAll(Iterable<Client> objects) {

    }

    @Override
    public void update(Client object) {

    }

    @Override
    public Collection<Client> searchByName(String nameQuery) {
        return null;
    }

    @Override
    public Collection<Client> getByCountry(String country) {
        return null;
    }
}
