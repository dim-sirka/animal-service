package com.dimsirka.animalservice.controllers;

import com.dimsirka.animalservice.entities.Animal;
import com.dimsirka.animalservice.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/animals")
public class AnimalController {
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Animal create(@RequestBody Animal animal){
        return animalService.create(animal);
    }

    @PutMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public Animal update(@RequestBody Animal animal, @PathVariable Long animalId){
        animal.setId(animalId);
        return animalService.update(animal);
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public Animal getById(@PathVariable Long animalId){
        return animalService.getById(animalId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Animal> getAll(){
        return animalService.getAll();
    }
}
