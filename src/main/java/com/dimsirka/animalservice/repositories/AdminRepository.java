package com.dimsirka.animalservice.repositories;

import com.dimsirka.animalservice.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
