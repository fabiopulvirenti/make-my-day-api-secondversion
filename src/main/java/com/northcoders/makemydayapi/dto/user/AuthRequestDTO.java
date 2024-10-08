package com.northcoders.makemydayapi.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
@Data
@AllArgsConstructor
public class AuthRequestDTO {

    @NotBlank(message ="First name is required")
    @Size(min = 1)
    private String firstname;

    @NotBlank(message = "Last name is required")
    @Size(min = 1)
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;

}
