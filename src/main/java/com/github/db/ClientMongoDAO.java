package com.github.db;

import com.github.Client;
import com.github.Platform;
import com.github.Videogame;
import com.github.exceptions.DatabaseException;
import com.github.exceptions.DuplicatedException;
import com.github.exceptions.NotFoundException;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * La implementacion del cliente DAO para mongo.
 *
 * @author Kevin Fernandez
 */
public class ClientMongoDAO implements ClientDAO {

    private static final Logger LOGGER = Logger.getLogger(ClientMongoDAO.class);

    private MongoCollection<Document> collection;
    private VideogameMongoDAO videogameMongoDAO;

    public ClientMongoDAO(MongoDatabase database, VideogameMongoDAO videogameMongoDAO) {
        this.collection = database.getCollection("clients");
        this.videogameMongoDAO = videogameMongoDAO;
    }

    @Override
    public void insert(Client cli) throws DatabaseException {
        LOGGER.debug("Insertando cliente: " + cli.getName());

        try {
            Client checkID = this.getByID(cli.getId());
            if (checkID == null) {
                Document newClient = clientToDocument(cli);
                collection.insertOne(newClient);
            } else {
                throw new NotFoundException("error al insertar cliente con id " + cli.getId() + " ya existe");
                // TIENE QUE SER NOTFOUND PORQUE NO HAY CODIGO DE ERROR
                //NO PUEDE SER NI DATABASEEXCEPTION NI ERROREXCEPTION
            }
        } catch (MongoException | NotFoundException throwables) {
            throw new DatabaseException("error al insertar cliente con id " + cli.getId(), throwables);
        }

    }

    private Document clientToDocument(Client cli) {

        ArrayList<Document> videogamesList = new ArrayList<Document>();

        Document newClient = new Document("id", cli.getId())
                .append("name", cli.getName())
                .append("country", cli.getCountry())
                .append("createAt", cli.getCreatedAt())
                .append("isPartner", cli.isPartner());

        if (cli.getVideogames() != null) {
            for (Videogame vi : cli.getVideogames()) {
                Document newVi = new Document();
                newVi.append("id", vi.getId());
            }

            newClient.append("videogames", videogamesList);
        }

        return newClient;
    }

    private Client documentToClient(Document cli) throws NotFoundException, DatabaseException {

        int id = cli.getInteger("id");
        String name = cli.getString("name");
        String country = cli.getString("country");
        Date createAt = (Date) cli.getDate("createAt");
        Boolean isPartner = cli.getBoolean("isPartner");

        Client newClient = new Client(id, name, country, createAt, isPartner);

        if (cli.containsKey("videogames")) {

            List<Document> videogamesList = cli.getList("videogames", Document.class);

            for (Document vi : videogamesList) {

                id = vi.getInteger("id");

                Videogame viDatabase = videogameMongoDAO.getByID(id);

                Videogame newVi = new Videogame(id,
                        viDatabase.getName(),
                        viDatabase.getPlatform(),
                        viDatabase.getReleaseDate(),
                        viDatabase.getPrice());

                newClient.getVideogames().add(newVi);
            }
        }

        return newClient;
    }

    @Override
    public Client getByID(Integer id) throws NotFoundException, DatabaseException {
        LOGGER.debug("Buscando cliente por id: " + id);

        Client client = null;

        try {
            MongoCursor<Document> cursor = collection.find(Filters.eq("id", id)).iterator();

            if (cursor.hasNext()) {
                Document d = cursor.next();
                client = documentToClient(d);
            } else {
                throw new NotFoundException(String.format("el cliente con id %d no se ha encontrado", id));
            }
        } catch (MongoException e) {
            throw new DatabaseException("error al obtener cliente con id " + id, e);
        }
        return client;
    }

    @Override
    public Collection<Client> getAll() throws DatabaseException {
        LOGGER.debug("Buscando todos los clientes");

        List<Client> clients = new ArrayList<>();

        try {
            MongoCursor<Document> cursor = collection.find().iterator();
            if (cursor.hasNext()) {
                Document d = cursor.next();
                clients.add(documentToClient(d));
            }
        } catch (MongoException | NotFoundException throwables) {
            throw new DatabaseException("error al obtener todos los clientes", throwables);
        }

        return clients;
    }

    @Override
    public void delete(Integer id) throws NotFoundException, DatabaseException {
        try {
            DeleteResult cursor = collection.deleteOne(Filters.eq("id", id));

            if (cursor.wasAcknowledged()) {
                LOGGER.debug("Client id: " + id + " deleted");
            } else {
                throw new NotFoundException(String.format("el client con id %d no se ha encontrado", id));
            }
        } catch (MongoException e) {
            throw new DatabaseException("error al obtener client con id " + id, e);
        }
    }

    @Override
    public void deleteAll(Iterable<Client> objects) throws NotFoundException, DatabaseException {
        try {
            collection.drop();
        } catch (MongoException e) {
            throw new DatabaseException("error al obtener client con id ", e);
        }
    }

    @Override
    public void update(Client object) throws NotFoundException, DatabaseException {

        LOGGER.debug("Buscando cliente:");
        Document client = clientToDocument(object);

        Client clientBBDD = null;

        MongoCursor<Document> cursor = collection.find(Filters.eq("id", object.getId())).iterator();

        if (cursor.hasNext()) {
            Document d = cursor.next();
            clientBBDD = documentToClient(d);
        }

        LOGGER.debug("Update cliente:");
        collection.updateOne((Bson) clientBBDD,client);

    }

    @Override
    public Collection<Client> searchByName(String nameQuery) throws DatabaseException {
        LOGGER.debug("Buscando todos los clientes de nombre: " + nameQuery);

        List<Client> clients = new ArrayList<>();

        try {
            MongoCursor<Document> cursor = collection.find(Filters.eq("name", nameQuery)).iterator();
            if (cursor.hasNext()) {
                Document d = cursor.next();
                clients.add(documentToClient(d));
            }
        } catch (MongoException | NotFoundException | DatabaseException throwables) {
            throw new DatabaseException("error al obtener todos los clientes de nombre: " + nameQuery, throwables);
        }

        return clients;
    }

    @Override
    public Collection<Client> getByCountry(String country) throws DatabaseException {
        LOGGER.debug("Buscando todos los clientes de país: " + country);

        List<Client> clients = new ArrayList<>();

        try {
            MongoCursor<Document> cursor = collection.find(Filters.eq("country", country)).iterator();
            if (cursor.hasNext()) {
                Document d = cursor.next();
                clients.add(documentToClient(d));
            }
        } catch (MongoException | NotFoundException | DatabaseException throwables) {
            throw new DatabaseException("error al obtener todos los clientes de país: " + country, throwables);
        }

        return clients;
    }
}
