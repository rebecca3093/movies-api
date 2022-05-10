package com.codeup.fortran_movies_api.web;

import com.codeup.fortran_movies_api.data.Movie;
import com.codeup.fortran_movies_api.data.MoviesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    private List<Movie> sampleMovies = setMovies();


    private final MoviesRepository moviesRepository;

    public MoviesController(MoviesRepository moviesRepository){
        this.moviesRepository = moviesRepository;
    }





    @GetMapping
    public Movie one() {
        return sampleMovies.get(1);
    }

    @GetMapping("all") // Path becomes: /api/movies/all
    public List<Movie> getAll() {
        return sampleMovies;
    }

    @GetMapping("{id}") // Define the path variable to use here
    public Movie getById(@PathVariable int id) { // Actually use the path variable here by annotating a parameter with @PathVariable
        return sampleMovies.stream().filter((movie) -> {
                    return movie.getId() == id; // filter out non-matching movies
                })
                .findFirst() // isolate to first match
                .orElse(null); // prevent errors by returning null... not the greatest practice, but it'll do for now
    }

    @GetMapping("search")
    public Movie getByTitle (@RequestParam String title){
        Movie movieToReturn = null;

        for (Movie movie : sampleMovies){
            if (movie.getTitle().equals(title)){
                movieToReturn = movie;
            }
        }
        return movieToReturn;
    }

    @PostMapping
    public void create(@RequestBody Movie movie){
        moviesRepository.save(movie);
    }


    @PostMapping("all")  // /api/movies/many POST
    public void createMany(@RequestBody List<Movie> movies){
        System.out.println(movies);
    }




    private List<Movie> setMovies() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie(2, "Pulp Fiction", "1994", "Quentin Tarantino",
                "Samuel L. Jackson, Uma Therman, Bruce Willis, John Travolta, Ving Rhames",
                "10", "action, drama, suspense, cult classic, crime",
                "Vincent Vega (John Travolta) and Jules Winnfield (Samuel L. Jackson) are hitmen with a penchant for philosophical discussions. " +
                        "In this ultra-hip, multi-strand crime movie, their storyline is interwoven with those of their boss, " +
                        "gangster Marsellus Wallace (Ving Rhames) ; his actress wife, Mia (Uma Thurman) ; " +
                        "struggling boxer Butch Coolidge (Bruce Willis) ; master fixer Winston Wolfe (Harvey Keitel) and a nervous pair of armed robbers, " +
                        "\"Pumpkin\" (Tim Roth) and \"Honey Bunny\" (Amanda Plummer)."));
        movies.add(new Movie(1, "The Big Lebowski",
                "1995", "The Cohen Bros",
                "Jeff Bridges, John Goodman, Steve Buscemi",
                "idk bro", "comedy, drama?",
                "the dude just wanted to relax and go bowling"));

        return movies;
    }
}
