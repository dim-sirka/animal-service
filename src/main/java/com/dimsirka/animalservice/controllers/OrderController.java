package com.dimsirka.animalservice.controllers;

import com.dimsirka.animalservice.dtoes.OrderDto;
import com.dimsirka.animalservice.entities.Order;
import com.dimsirka.animalservice.entities.OrderStatus;
import com.dimsirka.animalservice.mapper.OrderDtoMapper;
import com.dimsirka.animalservice.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
@RequestMapping("api/orders")
public class OrderController {
    private OrderService orderService;
    private OrderDtoMapper mapper;

    public OrderController(OrderService orderService, OrderDtoMapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@Validated @RequestBody OrderDto orderDto){
        return mapper.toDto(orderService.create(mapper.toEntity(orderDto)));
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@Validated @RequestBody OrderDto orderDto, @PathVariable Long orderId){
        orderDto.setId(orderId);
        return mapper.toDto(orderService.update(mapper.toEntity(orderDto)));
    }

    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getById(@PathVariable Long orderId){
        return mapper.toDto(orderService.getById(orderId));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAll(){
        return mapper.toDtoList(orderService.getAll());
    }

    @PutMapping("/cancel/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public void cancel(@PathVariable Long orderId){
        Order persistentOrder = orderService.getById(orderId);
        persistentOrder.setOrderStatus(OrderStatus.CANCELED);
        orderService.update(persistentOrder);
    }


}
