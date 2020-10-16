package com.dimsirka.animalservice.controllers;

import com.dimsirka.animalservice.dtoes.AnimalDto;
import com.dimsirka.animalservice.entities.Animal;
import com.dimsirka.animalservice.mapper.AnimalDtoMapper;
import com.dimsirka.animalservice.services.AnimalService;
import com.dimsirka.animalservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrderController {
    private OrderService orderService;
    private AnimalDtoMapper mapper;

    @Autowired
    public OrderController(AnimalService animalService, AnimalDtoMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDto create(@Validated @RequestBody OrderDto orderDto){
        return mapper.toDto(orderService.create(mapper.toEntity(orderDto)));
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto update(@Validated @RequestBody AnimalDto animalDto, @PathVariable Long animalId){
        Animal createdAnimal = orderService.getById(orderId);
        createdAnimal.setName(animalDto.getName());
        createdAnimal.setAnimalStatus(animalDto.getAnimalStatus());
        createdAnimal.setAnimalType(animalDto.getAnimalType());
        createdAnimal.setDescription(animalDto.getDescription());
        return mapper.toDto(animalService.update(createdAnimal));
    }

    @GetMapping("/{animalId}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto getById(@PathVariable Long animalId){
        return mapper.toDto(orderService.getById(orderId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> getAll(){
        return mapper.toDtoList(orderService.getAll());
    }
}
