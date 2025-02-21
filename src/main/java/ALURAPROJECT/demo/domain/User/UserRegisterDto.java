package ALURAPROJECT.demo.domain.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterDto(
    @NotBlank
    String nome ,
    @Email
    @NotBlank
    String email,
    @NotBlank
    String senha,
    EnumRole role

    ) {

}
