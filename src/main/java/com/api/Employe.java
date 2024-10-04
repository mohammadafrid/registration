package com.api;

public class Employe {

     private long id;
     private String name;

    public Employe(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
