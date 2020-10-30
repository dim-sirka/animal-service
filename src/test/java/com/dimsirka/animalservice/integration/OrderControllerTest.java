package com.dimsirka.animalservice.integration;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class OrderControllerTest {

    @Test
    void cancelOrderByIdTest_successFlow() {
        //create order
        OrderDto requestDto = OrderDto.builder()
                .animalId(testAnimal.getId())
                .userEmail("user@gmail.com")
                .userPhoneNumber("+380967834106")
                .userName("")
                .build();
        Order persistentOrder = mapper.toEntity(requestDto);
        orderRepository.save(persistentOrder);

        //Make call
        final String url = "/api/orders/cancel/" + persistentOrder.getId();
        ResponseEntity<Map<String, String>> response =
                this.template.exchange(url, HttpMethod.PUT, null, new ParameterizedTypeReference<Map<String, String>>() {});

        //Verify request succeed
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void cancelOrderByIdTest_unSuccessFlow() {
        //Make call
        final String url = "/api/orders/cancel/" + Integer.MAX_VALUE;
        ResponseEntity<Map<String, String>> response =
                this.template.exchange(url, HttpMethod.PUT, null, new ParameterizedTypeReference<Map<String, String>>() {});

        //Verify OrderNotFoundException exception
        assertEquals(404, response.getStatusCodeValue());
        assertEquals(exceptionMessage, response.getBody().get("error"));
    }
}
