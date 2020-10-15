package com.dimsirka.animalservice.entities;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AnimalType type;
    private String description;
    @Enumerated(EnumType.STRING)
    private AnimalStatus animalStatus;
    @CreatedDate
    private Timestamp createdDate;
    @LastModifiedDate
    private Timestamp updatedDate;
    @OneToMany(mappedBy = "animal")
    private List<Order> orders;
}
