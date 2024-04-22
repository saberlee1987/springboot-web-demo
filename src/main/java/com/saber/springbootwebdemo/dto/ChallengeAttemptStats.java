package com.saber.springbootwebdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeAttemptStats implements Serializable {
    private Long id;
    private String userAlias;
    private Integer factorA;
    private Integer factorB;
    private Integer resultAttempt;
    private Boolean isCorrect;
}