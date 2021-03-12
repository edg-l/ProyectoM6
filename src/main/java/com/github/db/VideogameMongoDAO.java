package com.github.db;

import com.github.Platform;
import com.github.Videogame;
import com.github.exceptions.DuplicatedException;
import com.github.exceptions.NotFoundException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Collection;

/**
 * La implementacion del videogame DAO para mongo.
 * @author Kevin Fernandez
 */
public class VideogameMongoDAO implements VideogameDAO {
    private MongoCollection<Document> collection;

    public VideogameMongoDAO(MongoDatabase database) {
        this.collection = database.getCollection("videogames");
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
