package br.com.growjects.controller;

import br.com.growjects.entity.dto.SignInRequest;
import br.com.growjects.entity.dto.SignUpRequest;
import br.com.growjects.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<String > signIn(@Valid @RequestBody SignInRequest req){
        String token = authService.signIn(req);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@Valid @RequestBody SignUpRequest req){
        String token = authService.signUp(req);
        return ResponseEntity.ok(token);
    }
}
