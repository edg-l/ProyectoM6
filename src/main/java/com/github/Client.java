package com.github;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Representa un cliente
 * @author Edgar Luque
 */
public class Client {
    private int id;
    private String name;
    private String country;
    private Date createdAt;
    private boolean isPartner;
    private List<Videogame> videogames;

    public Client(int id, String name, String country, Date createdAt, boolean isPartner) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.createdAt = createdAt;
        this.isPartner = isPartner;
        videogames = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isPartner() {
        return isPartner;
    }

    public void setPartner(boolean partner) {
        isPartner = partner;
    }

    public List<Videogame> getVideogames() {
        return videogames;
    }

    public void setVideogames(List<Videogame> videogames) {
        this.videogames = videogames;
    }
}
