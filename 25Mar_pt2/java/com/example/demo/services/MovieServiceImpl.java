package com.example.demo.services;

import com.example.demo.entities.Movie;
import com.example.demo.repositories.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    IMovieRepo movieRepo;

    @Override
    public void addMovie(Movie movie) throws Exception {
        if (movieRepo.findByName(movie.getName()) != null) {
            throw new Exception("Movie already exists: " + movie.getName());
        }
        movieRepo.save(movie);
    }

    @Override
    public void deleteMovie(String name) throws Exception {
        Movie movie = movieRepo.findByName(name);
        if (movie == null) {
            throw new Exception("Movie not found: " + name);
        }
        movieRepo.delete(movie);
    }

    @Override
    public List<Movie> searchAllMovies() throws Exception {
        return movieRepo.findAll();
    }

    @Override
    public List<Movie> searchByGenre(String genre) throws Exception {
        return movieRepo.findByGenre(genre);
    }

    @Override
    public void updateMovie(String name, Double rating, String genre) throws Exception {
        Movie movie = movieRepo.findByName(name);
        if (movie == null) {
            throw new Exception("Movie not found: " + name);
        }
        movie.setRating(rating);
        movie.setGenre(genre);
        movieRepo.save(movie);
    }
}