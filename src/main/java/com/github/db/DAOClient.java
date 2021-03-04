package com.github.db;

import com.github.Client;

public interface DAOClient extends DAO<Client, Integer> {
    Client getByName(String name);
    Client getByCountry(String country);
}
