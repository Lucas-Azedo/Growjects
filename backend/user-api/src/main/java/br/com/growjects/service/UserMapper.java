package br.com.growjects.service;

import br.com.growjects.model.dto.user.UserResponse;
import br.com.growjects.model.dto.user.UserRequest;
import br.com.growjects.model.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponse toUserResponse(User user){
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());

        return res;
    }

    public User toUserEntity(UserRequest req){
        User user = new User();
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        return user;
    }
}
