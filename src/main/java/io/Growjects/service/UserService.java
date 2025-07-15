package io.Growjects.service;

import io.Growjects.model.dto.user.UserResponse;
import io.Growjects.model.dto.user.UserSignRequest;
import io.Growjects.model.entity.User;
import io.Growjects.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        UserResponse res = new UserResponse();
        res.setEmail(user.getEmail());
        res.setName(user.getName());
        res.setId(user.getId());
        return res;
    }
}
