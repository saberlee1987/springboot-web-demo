package com.saber.springbootwebdemo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttemptDto {
    @NotNull(message = "{challenge.factorA.required}")
    @Min(value = 1,message = "{challenge.factorA.min}")
    @Max(value = 99,message = "{challenge.factorA.max}")
    private Integer factorA;
    @NotNull(message = "{challenge.factorB.required}")
    @Min(value = 1,message = "{challenge.factorB.min}")
    @Max(value = 99,message = "{challenge.factorB.max}")
    private Integer factorB;
    @NotBlank(message = "{challenge.alias.required}")
    private String alias;
    @NotNull(message = "{challenge.guess.required}")
    @Positive(message = "{challenge.guess.positive}")
    private Integer guess;
}