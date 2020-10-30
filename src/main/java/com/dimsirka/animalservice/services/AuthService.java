package com.dimsirka.animalservice.services;

import com.dimsirka.animalservice.dtoes.LoginDto;

public interface AuthService {

    String login(LoginDto loginDto);

    void logout();
}
