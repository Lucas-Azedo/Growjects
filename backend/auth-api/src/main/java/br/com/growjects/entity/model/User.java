package br.com.growjects.entity.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("users")
@Getter
@Setter
public class User {
    @Id
    private UUID id;

    private String name;
    private String email;
    private String password;
}
