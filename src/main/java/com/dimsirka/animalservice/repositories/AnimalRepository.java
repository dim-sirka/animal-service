package com.dimsirka.animalservice.repositories;

import com.dimsirka.animalservice.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
