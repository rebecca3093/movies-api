/*
package com.codeup.fortran_movies_api.data;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "actors")
public class Actor {

    @Id
    @GeneratedValue

    @ManyToMany
    @JoinTable(name = "movie-actor",
            joinColumns = @JoinTable(name = "actor_name", foreignKey = "id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id")
    )
    public List<Movie> actors;

    private int id;
    private String actor_name;

    public Actor(int id, String actor_name) {
        this.id = id;
        this.actor_name = actor_name;
    }

    public Actor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }
}
*/
