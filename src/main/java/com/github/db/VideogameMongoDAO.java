package com.github.db;

import com.github.Platform;
import com.github.Videogame;
import com.github.exceptions.DuplicatedException;
import com.github.exceptions.NotFoundException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.sql.Date;
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
    public void insert(Videogame vi) throws DuplicatedException {
        Document newVi = new Document();
        newVi.append("id", vi.getId())
                .append("name", vi.getName())
                .append("platform", vi.getPlatform().ordinal())
                .append("releaseDate", vi.getReleaseDate())
                .append("price", vi.getPrice());

        collection.insertOne(newVi);
    }

    @Override
    public Videogame getByID(Integer id) throws NotFoundException {

        Document vi = new Document();

        //int id = vi.getInteger("id");
        String name = vi.getString("name");
        Platform platform = Platform.values()[vi.getInteger("platform")];
        Date releaseDate = (Date) vi.getDate("releaseDate");
        int price = vi.getInteger("price");

        Videogame newVi = new Videogame(id,name,platform,releaseDate,price);
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
