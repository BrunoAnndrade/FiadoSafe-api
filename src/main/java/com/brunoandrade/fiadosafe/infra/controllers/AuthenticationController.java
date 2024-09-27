package com.brunoandrade.fiadosafe.infra.controllers;

import com.brunoandrade.fiadosafe.infra.dto.AuthenticationDTO;
import com.brunoandrade.fiadosafe.infra.dto.LoginResponseDTO;
import com.brunoandrade.fiadosafe.infra.dto.RegisterDTO;
import com.brunoandrade.fiadosafe.infra.domain.User;
import com.brunoandrade.fiadosafe.infra.services.TokenService;
import com.brunoandrade.fiadosafe.infra.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Controller to register and login Users")
public class AuthenticationController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationController(TokenService tokenService, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Operation(
            summary = "User login",
            description = "Authenticate a user using login credentials and return a JWT token."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successfully authenticated, returns a JWT token"),
            @ApiResponse(responseCode = "400", description = "Invalid credentials or request body format"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(
            summary = "User registration",
            description = "Register a new user in the system with login, password, and role."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User successfully registered"),
            @ApiResponse(responseCode = "400", description = "User with the same login already exists or invalid request body"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register (@RequestBody @Valid RegisterDTO data){
        if(this.userRepository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        var newUser = new User(data.login(),encryptedPassword, data.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
