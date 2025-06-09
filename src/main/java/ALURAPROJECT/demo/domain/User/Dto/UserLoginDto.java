package ALURAPROJECT.demo.domain.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserLoginDto(
@Email
@NotBlank    
String email,
@NotBlank
String senha) {

}
