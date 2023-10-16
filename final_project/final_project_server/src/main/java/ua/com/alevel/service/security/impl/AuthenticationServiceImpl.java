package ua.com.alevel.service.security.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.alevel.api.data.request.RegisterData;
import ua.com.alevel.api.data.response.AuthenticationData;
import ua.com.alevel.config.processor.annotations.InjectLog;
import ua.com.alevel.config.security.JwtService;
import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.exception.UserExistsException;
import ua.com.alevel.persistence.entity.token.Token;
import ua.com.alevel.persistence.entity.user.Personal;
import ua.com.alevel.persistence.repository.token.TokenRepository;
import ua.com.alevel.persistence.repository.user.PersonalRepository;
import ua.com.alevel.persistence.type.TokenType;
import ua.com.alevel.service.logger.LoggerService;
import ua.com.alevel.service.logger.LoggingLevel;
import ua.com.alevel.service.security.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PersonalRepository personalRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @InjectLog
    private LoggerService loggerService;

    public AuthenticationServiceImpl(
            PersonalRepository personalRepository,
            TokenRepository tokenRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            @Qualifier("authenticationManager")
            AuthenticationManager authenticationManager) {
        this.personalRepository = personalRepository;
        this.tokenRepository = tokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthenticationData register(RegisterData data) {
        if (personalRepository.existsByUsername(data.getUsername())) {
            throw new UserExistsException("User already exists");
        }
        Personal personal = new Personal();
        personal.setUsername(data.getUsername());
        personal.setPassword(passwordEncoder.encode(data.getPassword()));
        personalRepository.save(personal);
        String token = jwtService.generateToken(personal);
        saveToken(token, personal);
        return new AuthenticationData(token);
    }

    @Override
    public AuthenticationData login(RegisterData data) {
        loggerService.log(LoggingLevel.INFO, "User try login: " + data.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword())
        );
        Personal personal = personalRepository.findByUsername(data.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Token token = tokenRepository.findByUser(personal)
                .orElseThrow(() -> new EntityNotFoundException("Token not found"));
        String accessToken = token.getToken();
        if (jwtService.isTokenExpired(accessToken)) {
            tokenRepository.deleteById(token.getId());
            accessToken = jwtService.generateToken(personal);
            saveToken(accessToken, personal);
        }
        return new AuthenticationData(accessToken);
    }

    private void saveToken(String accessToken, Personal personal) {
        Token token = new Token();
        token.setToken(accessToken);
        token.setTokenType(TokenType.BEARER);
        token.setUser(personal);
        token.setExpired(false);
        token.setRevoked(false);
        tokenRepository.save(token);
    }
}
