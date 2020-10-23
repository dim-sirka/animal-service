package com.dimsirka.animalservice.services.impl;

import com.dimsirka.animalservice.entities.Order;
import com.dimsirka.animalservice.exceptions.OrderNotFoundException;
import com.dimsirka.animalservice.repositories.OrderRepository;
import com.dimsirka.animalservice.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        getByIdOrThrowException(order.getId());
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return getByIdOrThrowException(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    private Order getByIdOrThrowException(Long id){
        return orderRepository.findById(id).
                orElseThrow(()-> new OrderNotFoundException("Order with a specified id isn't found!"));
    }
}

