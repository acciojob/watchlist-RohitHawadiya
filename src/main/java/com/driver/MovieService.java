package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie)
    {
        String ans=movieRepository.addMovie(movie);

        return ans;
    }

    public String addDirector(Director director)
    {
        String ans=movieRepository.addDirector(director);

        return ans;
    }

    public String addMovieDirectorPair(String movieName,String directorName)
    {
       String ans=movieRepository.addMovieDirectorPair(movieName,directorName);

       return ans;
    }

    public Movie getMovieByName(String movie1)
    {
        Movie movie=movieRepository.getMovieByName(movie1);

        return movie;
    }

    public Director getDirectorByName(String name)
    {
        Director director=movieRepository.getDirectorByName(name);

        return director;
    }

    public List<String> getMoviesByDirectorName(String name)
    {
        List<String>list=movieRepository.getMoviesByDirectorName(name);

        return list;
    }

    public List<String> getAllMovies()
    {
        List<String>list=movieRepository.getAllMovies();

        return list;
    }

    public String deleteDirectorByName(String name)
    {
        String ans=movieRepository.deleteDirectorByName(name);
        return ans;
    }

    public String deleteAllDirectors()
    {
        String ans=movieRepository.deleteAllDirectors();

        return ans;
    }




}
