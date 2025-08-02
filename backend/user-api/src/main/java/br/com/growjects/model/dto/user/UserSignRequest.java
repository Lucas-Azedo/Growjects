package br.com.growjects.model.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserSignRequest {
    @NotBlank(message = "Name can't be null")
    private String name;

    @NotBlank(message = "E-mail can't be null")
    @Email(message = "E-mail should be valid")
    private String email;

    @NotBlank(message = "Password can't be null")
    @Size(min = 6, message = "Password must be longer than 6 characters")
    @Pattern.List({
            @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "Password must contain an uppercase letter"),
            @Pattern(regexp = "^(?=.*\\d).*$", message = "Password must contain a number"),
            @Pattern(regexp = "^(?=.*[@#$%^&+=!]).*$", message = "Password must contain a special character (@#$%^&+=!)")
    })
    private String password;
}
