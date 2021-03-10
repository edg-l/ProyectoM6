package com.github.db;

/**
 * Gestor persistencia JDBC
 * @author Edgar Luque
 */
public class GestorPersistenciaJDBC implements GestorPersistencia {
    private ClientJDBCDAO clientRepo;
    private VideogameJDBCDAO videogameRepo;

    public GestorPersistenciaJDBC(ConexioJDBC conexioJDBC) {
        clientRepo = new ClientJDBCDAO(conexioJDBC);
        videogameRepo = new VideogameJDBCDAO(conexioJDBC);
    }

    @Override
    public ClientDAO getClientDAO() {
        return clientRepo;
    }

    @Override
    public VideogameDAO getVideogameDAO() {
        return videogameRepo;
    }
}
