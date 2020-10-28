package com.dimsirka.animalservice.security;

import com.dimsirka.animalservice.repositories.TokenRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@Slf4j
public class TokenProvider implements AuthenticationProvider {

    private TokenRepository tokenRepository;

    @Autowired
    public TokenProvider(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        return tokenRepository.findByToken(tokenAuthentication.getToken())
                        .filter(Objects::nonNull)
                        .map(token->{
                            tokenAuthentication.setUserDetails(token.getAdmin());
                            tokenAuthentication.setAuthenticated(true);
                            log.info("Admin <{}> was authenticated!", token.getAdmin().getEmail());
                            return tokenAuthentication;
                        })
                        .orElse(null);
    }

    @Override
    public boolean supports(Class<?> authenticationClass) {
        return TokenAuthentication.class.equals(authenticationClass);
    }
}
