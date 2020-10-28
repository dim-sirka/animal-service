package com.dimsirka.animalservice.services.impl;

import com.dimsirka.animalservice.entities.Animal;
import com.dimsirka.animalservice.entities.AnimalStatus;
import com.dimsirka.animalservice.exceptions.AnimalNotFoundException;
import com.dimsirka.animalservice.repositories.AnimalRepository;
import com.dimsirka.animalservice.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal create(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Animal animal) {
        getByIdOrThrowException(animal.getId());
        return animalRepository.save(animal);
    }

    @Override
    public Animal getById(Long id) {
        return getByIdOrThrowException(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> getAllByAnimalStatus(AnimalStatus animalStatus) {
        return animalRepository.findAllByAnimalStatus(animalStatus);
    }

    private Animal getByIdOrThrowException(Long id){
        return animalRepository.findById(id).
                orElseThrow(()-> new AnimalNotFoundException("Animal with a specified id not found!"));
    }
}
