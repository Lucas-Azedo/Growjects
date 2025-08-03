package br.com.growjects.entity.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
}
