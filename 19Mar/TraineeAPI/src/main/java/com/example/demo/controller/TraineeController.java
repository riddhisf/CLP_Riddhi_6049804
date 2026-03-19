package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Trainee;
import com.example.demo.service.ITraineeService;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

    @Autowired
    private ITraineeService service;

    @GetMapping
    public List<Trainee> getAllTrainees() {
        return service.getAllTrainees();
    }

    @GetMapping("/{id}")
    public Trainee getTraineeById(@PathVariable int id) {
        return service.getTraineeById(id);
    }

    @GetMapping("/name/{name}")
    public List<Trainee> getTraineeByName(@PathVariable String name) {
        return service.getTraineeByName(name);
    }

    @PostMapping
    public Trainee addTrainee(@RequestBody Trainee trainee) {
        return service.addTrainee(trainee);
    }

    @PutMapping("/{id}")
    public Trainee updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
        return service.updateTrainee(id, trainee);
    }

    @DeleteMapping("/{id}")
    public String deleteTrainee(@PathVariable int id) {
        service.deleteTrainee(id);
        return "Trainee deleted successfully with id: " + id;
    }
}