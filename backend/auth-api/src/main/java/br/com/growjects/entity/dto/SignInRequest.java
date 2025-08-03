package br.com.growjects.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignInRequest {
    @NotBlank(message = "E-mail is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
}
