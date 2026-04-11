package com.example.demo.services;

import com.example.demo.entities.Movie;
import java.util.List;

public interface IMovieService {
	public void addMovie(Movie movie) throws Exception;
	public void deleteMovie(String name) throws Exception;
	public List<Movie> searchAllMovies() throws Exception;
	public List<Movie> searchByGenre(String genre) throws Exception;
	public void updateMovie(String name, Double rating,String genre) throws Exception;
}