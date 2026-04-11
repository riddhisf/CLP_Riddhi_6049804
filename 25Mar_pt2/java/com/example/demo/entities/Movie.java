package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    @NotBlank(message = "Movie Name is required !!")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "Movie Name should be only alphanumeric")
    private String name;

    @NotNull(message = "Rating is required !!")
    @DecimalMin(value = "1.0", message = "Rating needs to be a number: eg: 2.5. Rating is on Scale 1-5")
    @DecimalMax(value = "5.0", message = "Rating needs to be a number: eg: 2.5. Rating is on Scale 1-5")
    private Double rating; 

    @NotBlank(message = "Select Genre!!!")
    private String genre;

    public Movie() {}

    public Movie(String name, double rating, String genre) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public String toString() {
        return "Movies [id=" + id + ", name=" + name + ", rating=" + rating + ", genre=" + genre + "]";
    }
}