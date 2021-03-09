package com.github.db;

import com.github.Client;

import java.util.Collection;

/**
 * Interfície DAO para el cliente.
 * @author Edgar Luque
 */
public interface ClientDAO extends DAO<Client, Integer> {
    /**
     * Buscar clientes por nombre.
     * @param nameQuery El nombre a buscar.
     * @return Una lista de clientes con nombres parecidos.
     */
    Collection<Client> searchByName(String nameQuery);

    /**
     * Buscar clientes por country.
     * @param country El country.
     * @return Una lista de clientes con este country.
     */
    Collection<Client> getByCountry(String country);
}
