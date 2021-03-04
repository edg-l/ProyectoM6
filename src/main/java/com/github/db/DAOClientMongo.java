package com.github.db;

import com.github.Client;

import java.util.Collection;

public class DAOClientMongo implements DAOClient {
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
    public Client getByName(String name) {
        return null;
    }

    @Override
    public Client getByCountry(String country) {
        return null;
    }
}
