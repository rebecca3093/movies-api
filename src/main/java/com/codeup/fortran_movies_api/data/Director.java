package com.codeup.fortran_movies_api.data;

import javax.persistence.*;

@Entity
@Table(name = "directors")
public class Director {
    public Director() {
    }
    @Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
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
    private int id;
    private String name;
    public Director(int id, String name) {
        this.id = id;
        this.name = name;
    }
}