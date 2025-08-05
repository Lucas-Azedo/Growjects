package br.com.growjects.service;

import br.com.growjects.entity.dto.SignInRequest;
import br.com.growjects.entity.dto.SignUpRequest;
import br.com.growjects.entity.model.User;
import br.com.growjects.exception.business.InvalidCredentialException;
import br.com.growjects.exception.business.UserAlreadyExistsException;
import br.com.growjects.exception.business.UserNotFoundException;
import br.com.growjects.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    UserRepository userRepository;
    TokenService tokenService;
    PasswordEncoder passwordEncoder;

    public String signUp(SignUpRequest req){
        Optional<User> existingUser = userRepository.findByEmail(req.getEmail());

        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("E-mail already registered");
        }

        User newUser = new User();
        UUID id = UUID.randomUUID();

        newUser.setId(id);
        newUser.setName(req.getName());
        newUser.setEmail(req.getEmail());
        newUser.setPassword(passwordEncoder.encode(req.getPassword()));

        userRepository.save(newUser);

        //PEGAR ROLES DEVE FICAR AQUI
        List<String> userRoles = null;

        return tokenService.buildToken(newUser, userRoles);
    }
    public String signIn(SignInRequest req){
        Optional<User> existingUser = userRepository.findByEmail(req.getEmail());

        if(existingUser.isEmpty()){
            throw new UserNotFoundException("User not found");
        }

        User user = existingUser.get();

        if(!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new InvalidCredentialException("Credentials are invalid");
        }

        //PEGAR ROLES DEVE FICAR AQUI
        List<String> userRoles = null;

        return tokenService.buildToken(user, userRoles);
    }
}
