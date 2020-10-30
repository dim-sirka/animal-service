package com.dimsirka.animalservice.services;
import com.dimsirka.animalservice.entities.Order;
import java.util.List;

public interface OrderService {
    Order create (Order order);

    Order update (Order order);

    Order getById(Long id);

    List<Order> getAll();
}
