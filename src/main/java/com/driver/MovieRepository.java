package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> MovieDb=new HashMap<>();

    HashMap<String,Director> DirectorDb=new HashMap<>();

    HashMap<String,List<String>> DirectorMovieDb=new HashMap<>();
    public String addMovie(Movie movie)
    {
        String name=movie.name;

        MovieDb.put(name,movie);

        return "movie added successfully";
    }

    public String addDirector(Director director)
    {
        String name=director.name;

        DirectorDb.put(name,director);

        return "director added successfully";
    }

    public String addMovieDirectorPair(String movieName,String directorName)
    {
        if(DirectorMovieDb.containsKey(directorName))
          {
            List<String> l = DirectorMovieDb.get(directorName);
            l.add(movieName);
            DirectorMovieDb.put(directorName,l);
           }
        else {
           List<String>l=new ArrayList<>();
           l.add(movieName);
           DirectorMovieDb.put(directorName,l);
        }
        return "pair added successfully";
    }

    public Movie getMovieByName(String name)
    {
        Movie movie1=MovieDb.get(name);

        return movie1;
    }

    public Director getDirectorByName(String name)
    {
        Director director=DirectorDb.get(name);

        return director;
    }

    public List<String> getMoviesByDirectorName(String name)
    {
       // List<String>list=new ArrayList<>();
        for(String s:DirectorMovieDb.keySet())
        {
            if(s.equals(name))
            {
                return DirectorMovieDb.get(s);
            }
        }
         return new ArrayList<>();
    }

    public List<String> getAllMovies()
    {
        List<String>list=new ArrayList<>();

        for(String s:MovieDb.keySet())
        {
            list.add(s);
        }
        return list;
    }

    public String deleteDirectorByName(String name)
    {
        DirectorDb.remove(name);

        for(String s:DirectorMovieDb.keySet())
        {
            if(s.equals(name))
            {
                List<String>list=DirectorMovieDb.get(s);
                DirectorMovieDb.remove(s);
                for(String s1:list)
                {
                  MovieDb.remove(s1);
                }
            }
        }
        return "deletion successfully";
    }

    public String deleteAllDirectors()
    {
        DirectorDb.clear();

        for(List<String>list:DirectorMovieDb.values())
        {
            for(String s:list)
            {
                MovieDb.remove(s);
            }
        }
        DirectorMovieDb.clear();
        return "deletion successfully";
    }
}
