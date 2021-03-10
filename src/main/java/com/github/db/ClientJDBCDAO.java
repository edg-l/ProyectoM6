package com.github.db;

import com.github.Client;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

/**
 * La implementacion del cliente DAO para sql.
 */
public class ClientJDBCDAO implements ClientDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientJDBCDAO.class);
    private Connection connection;

    public ClientJDBCDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Client client) {
        LOGGER.debug("Insertando cliente: " + client.getName());
        try(PreparedStatement stmt = connection.prepareStatement(
                "insert into client (name, country, createdAt, isPartner) values (?,?,?,?)"
        )) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getCountry());
            stmt.setDate(3, client.getCreatedAt());
            stmt.setBoolean(4, client.isPartner());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Client getByID(Integer id) {
        LOGGER.debug("Buscando cliente por id: " + id);

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
