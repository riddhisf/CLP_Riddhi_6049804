package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Movie;

public interface IMovieRepo extends JpaRepository<Movie, Integer>{
	List<Movie> findByGenre(String genre);

	Movie findByName(String name);

}
