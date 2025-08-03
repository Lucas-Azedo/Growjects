package br.com.growjects.controller;

import br.com.growjects.entity.dto.SignInRequest;
import br.com.growjects.entity.dto.SignUpRequest;
import br.com.growjects.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController ("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<Void > signIn(SignInRequest req){
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/signUp")
    public ResponseEntity<Void> signUp(SignUpRequest req){
        return ResponseEntity.noContent().build();
    }
}
