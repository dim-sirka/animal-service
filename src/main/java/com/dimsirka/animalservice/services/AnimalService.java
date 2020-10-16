package com.dimsirka.animalservice.services;

import com.dimsirka.animalservice.entities.Animal;

import java.util.List;

public interface AnimalService {
    Animal create (Animal animal);

    Animal update (Animal animal);

    Animal getById(Long id);

    List<Animal> getAll();
}
