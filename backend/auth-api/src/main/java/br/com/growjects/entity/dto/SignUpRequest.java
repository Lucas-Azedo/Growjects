package br.com.growjects.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "E-mail is mandatory")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Pattern.List({
            @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "Password must contain an uppercase letter"),
            @Pattern(regexp = "^(?=.*\\d).*$", message = "Password must contain a number"),
            @Pattern(regexp = "^(?=.*[@#$%^&+=!]).*$", message = "Password must contain a special character (@#$%^&+=!)")
    })
    private String password;
}
