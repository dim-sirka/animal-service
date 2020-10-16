package com.dimsirka.animalservice.dtoes;

import com.dimsirka.animalservice.entities.Animal;
import com.dimsirka.animalservice.entities.AnimalStatus;
import com.dimsirka.animalservice.entities.AnimalType;
import com.dimsirka.animalservice.entities.OrderStatus;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    @NotBlank(message = "User email should be specified")
    private String userEmail;
    @NotNull(message = "User phone number should be specified")
    private AnimalType userPhoneNumber;
    @NotBlank(message = "User name should be specified")
    private OrderStatus orderStatus;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Animal animal;
}
