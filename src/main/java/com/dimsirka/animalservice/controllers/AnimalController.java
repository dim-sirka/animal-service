package com.dimsirka.animalservice.controllers;

import com.dimsirka.animalservice.dtoes.AnimalDto;
import com.dimsirka.animalservice.entities.Animal;
import com.dimsirka.animalservice.entities.AnimalStatus;
import com.dimsirka.animalservice.mapper.AnimalDtoMapper;
import com.dimsirka.animalservice.services.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/animals")
public class AnimalController {
    private AnimalService animalService;
    private AnimalDtoMapper mapper;

    @Autowired
    public AnimalController(AnimalService animalService, AnimalDtoMapper mapper) {
        this.animalService = animalService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDto create(@Validated @RequestBody AnimalDto animalDto){
        return mapper.toDto(animalService.create(mapper.toEntity(animalDto)));
    }

    @PutMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto update(@Validated @RequestBody AnimalDto animalDto, @PathVariable Long animalId){
        Animal createdAnimal = animalService.getById(animalId);
        createdAnimal.setName(animalDto.getName());
        createdAnimal.setAnimalStatus(animalDto.getAnimalStatus());
        createdAnimal.setAnimalType(animalDto.getAnimalType());
        createdAnimal.setDescription(animalDto.getDescription());
        return mapper.toDto(animalService.update(createdAnimal));
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto getById(@PathVariable Long animalId){
        return mapper.toDto(animalService.getById(animalId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> getAll(){
        return mapper.toDtoList(animalService.getAll());
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> getByIdAndAnimalStatus(@RequestParam AnimalStatus animalStatus){
        return mapper.toDtoList(animalService.getAllByAnimalStatus(animalStatus));
    }
}
