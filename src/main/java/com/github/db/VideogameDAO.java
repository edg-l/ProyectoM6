package com.github.db;

import com.github.Platform;
import com.github.Videogame;

import java.util.Collection;

/**
 * Interfície para el videogame.
 * @author Edgar Luque
 */
public interface VideogameDAO extends DAO<Videogame, Integer> {
    /**
     * Busca videojuegos por su nombre.
     * @param name El nombre.
     * @return La lista de videojuegos encontrados.
     */
    Collection<Videogame> getByName(String name);

    /**
     * Busca videojuegos por su plataforma.
     * @param platform La plataforma.
     * @return La lista de videojuegos encontrados.
     */
    Collection<Videogame> getByPlatform(Platform platform);
}
