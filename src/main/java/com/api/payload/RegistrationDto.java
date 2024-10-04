package com.api.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistrationDto {

    @NotEmpty
    @Size(min =2 , message = "Min should be 2 lettes")
    private String name;

    @Email
    private String email;

    @Size(min = 10 , max = 10 , message = "Number should be 10 digits")
    private String mobile;


}