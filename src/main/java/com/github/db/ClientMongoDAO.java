package com.github.db;

import com.github.Client;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Collection;


/**
 * La implementacion del cliente DAO para mongo.
 * @author Kevin Fernandez
 */
public class ClientMongoDAO implements ClientDAO {
    private MongoCollection<Document> collection;

    public ClientMongoDAO(MongoDatabase database) {
        this.collection = database.getCollection("clients");
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
