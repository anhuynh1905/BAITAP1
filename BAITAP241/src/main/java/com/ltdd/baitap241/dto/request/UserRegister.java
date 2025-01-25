package com.ltdd.baitap241.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegister {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 12, message = "Username must be 3-12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain letters, numbers, and underscores")
    private String username;

    @NotBlank(message = "password should not be blank")
    @Size(min = 6, max = 15, message = "Password must be 6-15 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must have 8+ chars, 1 uppercase, 1 digit, and 1 special character")
    private String password;

    @NotBlank(message = "email should not be blank")
    @Email(message = "This is not in email form")
    private String email;
}
