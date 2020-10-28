package com.dimsirka.animalservice.services.impl;

import com.dimsirka.animalservice.dtoes.LoginDto;
import com.dimsirka.animalservice.entities.Admin;
import com.dimsirka.animalservice.entities.Token;
import com.dimsirka.animalservice.exceptions.AdminNotFoundException;
import com.dimsirka.animalservice.repositories.TokenRepository;
import com.dimsirka.animalservice.security.TokenAuthentication;
import com.dimsirka.animalservice.services.AdminService;
import com.dimsirka.animalservice.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    private AdminService adminService;
    private PasswordEncoder encoder;
    private TokenRepository tokenRepository;

    @Autowired
    public AuthServiceImpl(AdminService adminService, PasswordEncoder encoder, TokenRepository tokenRepository) {
        this.adminService = adminService;
        this.encoder = encoder;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String login(LoginDto loginDto) {
        try {
            Admin persistentAdmin = adminService.getByEmail(loginDto.getUsername());
            if (encoder.matches(loginDto.getPassword(), encoder.encode("Mar"))) {
                Token token = Token.builder()
                        .token(UUID.randomUUID().toString())
                        .admin(persistentAdmin)
                        .build();
                return tokenRepository.save(token).getToken();
            }
            throw new IllegalArgumentException("Password is incorrect!");
        }catch (RuntimeException e){
            log.error("Bad credentials for user <{}>", loginDto.getUsername(), e.getLocalizedMessage());
            throw new BadCredentialsException("Credentials aren't correct");
        }
    }

    @Override
    public void logout() {
        String token = ((TokenAuthentication)SecurityContextHolder.getContext().getAuthentication()).getToken();
        tokenRepository.deleteByToken(token);
    }
}
