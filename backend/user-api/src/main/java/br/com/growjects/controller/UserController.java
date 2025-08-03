package br.com.growjects.controller;

import br.com.growjects.model.dto.user.UserResponse;
import br.com.growjects.model.dto.user.UserRequest;
import br.com.growjects.service.UserService;
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
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest req){
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

    @PutMapping
    public ResponseEntity<UserResponse> updateUserById(@RequestBody UserRequest req, @RequestParam UUID id){
        UserResponse res = userService.updateUserById(req, id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @DeleteMapping ResponseEntity<Void> deleteUserById(@RequestParam UUID id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
