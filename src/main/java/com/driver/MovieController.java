package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String>  addMovie(@RequestBody Movie movie)
    {
        String ans =movieService.addMovie(movie);

        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody Director director)
   {
       String ans=movieService.addDirector(director);

       return new ResponseEntity<>(ans,HttpStatus.CREATED);
   }

   @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName")String movieName, @RequestParam("dirName")String dirName)
   {
       String ans=movieService.addMovieDirectorPair(movieName,dirName);

       return new ResponseEntity<>(ans,HttpStatus.CREATED);
   }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName)
    {
       Movie movie=movieService.getMovieByName(movieName);

       return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String dirName)
    {
        Director director=movieService.getDirectorByName(dirName);

        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String name)
    {
        List<String>list=movieService.getMoviesByDirectorName(name);

        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> getAllMovies()
    {
        List<String>list=movieService.getAllMovies();

        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("directorName")String directorName)
    {
       String ans=movieService.deleteDirectorByName(directorName);

       return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors()
    {
        String ans=movieService.deleteAllDirectors();

        return new ResponseEntity<>(ans,HttpStatus.CREATED);
    }


}
