package io.Growjects.model.entity;

import io.Growjects.model.dto.user.UserSignRequest;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private UUID id;
    private String name;
    private String password;
    private String email;

    public void applyFrom(UserSignRequest req){
        User user = new User();
        user.setEmail(req.getEmail());
        user.setName(req.getName());
        user.setPassword(req.getPassword());
    }
}
