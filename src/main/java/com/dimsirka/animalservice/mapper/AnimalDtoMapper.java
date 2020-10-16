package com.dimsirka.animalservice.mapper;

import com.dimsirka.animalservice.dtoes.AnimalDto;
import com.dimsirka.animalservice.entities.Animal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnimalDtoMapper {

    public AnimalDto toDto(Animal animal){
        return AnimalDto.builder()
                .id(animal.getId())
                .name(animal.getName())
                .animalStatus(animal.getAnimalStatus())
                .createdDate(animal.getCreatedDate())
                .updatedDate(animal.getUpdatedDate())
                .description(animal.getDescription())
                .animalType(animal.getAnimalType()).build();
    }

    public Animal toEntity (AnimalDto animal){
        return Animal.builder()
                .name(animal.getName())
                .animalStatus(animal.getAnimalStatus())
                .description(animal.getDescription())
                .animalType(animal.getAnimalType()).build();
    }

    public List<AnimalDto> toDtoList(List<Animal> animals){
        return animals.stream().map(this::toDto).collect(Collectors.toList());
    }
}
