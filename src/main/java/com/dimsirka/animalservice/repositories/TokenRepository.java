package com.dimsirka.animalservice.repositories;

import com.dimsirka.animalservice.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByToken(String string);
    void deleteByToken(String string);
}
