package br.com.growjects.controller;

import br.com.growjects.entity.dto.SignInRequest;
import br.com.growjects.entity.dto.SignUpRequest;
import br.com.growjects.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController ("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // Trocar resposta para OK + TOKEN
    @PostMapping("/signIn")
    public ResponseEntity<Void > signIn(@Valid @RequestBody SignInRequest req){
        authService.signIn(req);
        return ResponseEntity.noContent().build();
    }
    
    // Trocar resposta para OK + TOKEN
    @PostMapping("/signUp")
    public ResponseEntity<Void> signUp(@Valid @RequestBody SignUpRequest req){
        authService.signUp(req);
        return ResponseEntity.noContent().build();
    }
}
