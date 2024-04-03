package com.saber.springbootwebdemo.domains.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttempt implements Serializable {
    private Long id;
    private Long userId;
    private String userAlias;
    private Integer factorA;
    private Integer factorB;
    private Integer resultAttempt;
    private Boolean isCorrect;
}