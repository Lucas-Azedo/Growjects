package br.com.growjects.model.dto.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {

    private UUID id;
    private String name;
    private String email;
}
