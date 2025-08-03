package br.com.growjects.service;

import br.com.growjects.model.dto.user.UserResponse;
import br.com.growjects.model.dto.user.UserRequest;
import br.com.growjects.model.entity.User;
import br.com.growjects.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest req){
        User user = userMapper.toUserEntity(req);

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    public UserResponse getUserById(UUID id){
        User user = getUserEntityById(id);
        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> getAllUsers(){
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> {
                    return userMapper.toUserResponse(user);
                })
                .collect(Collectors.toList());
    }

    public UserResponse updateUserById(UserRequest req, UUID id){
        User user = getUserEntityById(id);

        user.setName(req.getName());
        user.setEmail(req.getEmail());

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }

    public void deleteUser(UUID id){
        User user = getUserEntityById(id);
        userRepository.delete(user);
    }

    public User getUserEntityById(UUID id){
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
    }
}
