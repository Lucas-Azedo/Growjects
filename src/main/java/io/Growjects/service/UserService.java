package io.Growjects.service;

import io.Growjects.model.dto.user.UserResponse;
import io.Growjects.model.dto.user.UserSignRequest;
import io.Growjects.model.entity.User;
import io.Growjects.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse createUser(UserSignRequest req){
        User user = new User();

        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setPassword(req.getPassword());

        userRepository.save(user);

        return toUserResponse(user);
    }

    public UserResponse getUserById(UUID id){
        User user = getUserEntityById(id);
        return toUserResponse(user);
    }

    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(this::toUserResponse)
                .collect(Collectors.toList());
    }


    public void deleteUser(UUID id){
        User user = getUserEntityById(id);
        userRepository.delete(user);
    }

    public UserResponse toUserResponse(User user){
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());

        return res;
    }

    public User getUserEntityById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }

}
