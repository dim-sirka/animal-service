package com.dimsirka.animalservice.dtoes;

import com.dimsirka.animalservice.entities.AnimalStatus;
import com.dimsirka.animalservice.entities.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalDto {
    private Long id;
    @NotBlank( message = "Field should be specified")
    private String name;
    @NotNull( message = "Field should be specified")
    private AnimalType animalType;
    @NotBlank( message = "Field should be specified")
    private String description;
    @NotNull( message = "Field should be specified")
    private AnimalStatus animalStatus;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
