package com.saber.springbootwebdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttemptDto {
    private Integer factorA;
    private Integer factorB;
    private String alias;
    private Integer guess;
}