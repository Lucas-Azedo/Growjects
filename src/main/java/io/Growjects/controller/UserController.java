package io.Growjects.controller;

import io.Growjects.model.dto.user.UserResponse;
import io.Growjects.model.dto.user.UserSignRequest;
import io.Growjects.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserSignRequest req){
        UserResponse res = userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@RequestParam UUID id){
        UserResponse res = userService.getUserById(id);

        
        return ResponseEntity.status(HttpStatus.FOUND).body(res);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        List<UserResponse> res = userService.getAllUsers();

        if(res.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
    }
}
