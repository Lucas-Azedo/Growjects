package br.com.growjects.entity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignInRequest {
    private String email;
    private String password;
}
