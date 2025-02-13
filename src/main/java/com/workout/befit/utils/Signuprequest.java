package com.workout.befit.utils;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Signuprequest {
    @NotBlank @Size(min = 3, max = 20)
    private String username;
    @NotBlank @Size(min = 6, max = 40)
    private String password;
}
