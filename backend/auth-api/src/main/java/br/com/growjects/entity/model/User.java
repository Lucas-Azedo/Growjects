package br.com.growjects.entity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    @Id
    private UUID id;

    private String name;
    private String email;
    private String password;
}
