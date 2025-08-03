package br.com.growjects.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "Name can't be null")
    private String name;

    @NotBlank(message = "E-mail can't be null")
    @Email(message = "E-mail should be valid")
    private String email;
}
