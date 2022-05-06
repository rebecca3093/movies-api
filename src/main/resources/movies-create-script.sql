CREATE DATABASE IF NOT EXISTS movies_db;

USE movies_db;
#DROP TABLES WITH DEPENDENCIES

DROP TABLE IF EXISTS movie_genre;
DROP TABLE IF EXISTS movie_actor;
DROP TABLE IF EXISTS actors;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;


CREATE TABLE IF NOT EXISTS directors
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    director_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS genres
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(32),
    PRIMARY KEY (id)
);


Create Table IF NOT EXISTS movies
(
    id            INT UNSIGNED NOT NULL AUTO_INCREMENT,
    movie_title   varchar(120),
    plot          TEXT,
    year_released CHAR(4),
    poster        TEXT,
    rating        CHAR(1),
    director_id   INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (director_id) REFERENCES directors (id)
);

CREATE TABLE IF NOT EXISTS movie_genre
(
    movie_id INT UNSIGNED NOT NULL,
    genre_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);

CREATE
    TABLE IF NOT EXISTS actors
(

    id         INT UNSIGNED NOT NULL AUTO_INCREMENT,
    actor_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS movie_actor
(
    movie_id INT UNSIGNED NOT NULL,
    actor_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (id),
    FOREIGN KEY (actor_id) REFERENCES actors (id)
);





