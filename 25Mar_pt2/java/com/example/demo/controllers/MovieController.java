package com.example.demo.controllers;

import com.example.demo.entities.Movie;
import com.example.demo.services.MovieServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieServiceImpl mService;

    @RequestMapping("/greet")
    public ModelAndView processGreet() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "Welcome to Movie App");
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("/addMovie")
    public ModelAndView showAddMovie() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("newMovie", new Movie());
        mv.setViewName("addMovie");
        return mv;
    }

    @RequestMapping("/saveMovie")
    public ModelAndView saveMovie(@Valid @ModelAttribute("newMovie") Movie movie, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("addMovie");
            mv.addObject("newMovie", movie);
            return mv;
        }
        mService.addMovie(movie);
        return new ModelAndView("redirect:/addMovie");
    }

    @RequestMapping("/searchMovie")
    public ModelAndView showSearchMovie() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("searchMovie", new Movie());
        mv.setViewName("searchMovie");
        return mv;
    }

    @RequestMapping("/searchByGenre")
    public ModelAndView searchByGenre(@ModelAttribute("searchMovie") Movie movie) throws Exception {
        List<Movie> list = mService.searchByGenre(movie.getGenre());
        ModelAndView mv = new ModelAndView("searchMovie");
        mv.addObject("searchMovie", new Movie());
        mv.addObject("movies", list);
        return mv;
    }
}