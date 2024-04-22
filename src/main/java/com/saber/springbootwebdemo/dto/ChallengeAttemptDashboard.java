package com.saber.springbootwebdemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChallengeAttemptDashboard {
    private List<ChallengeAttemptStats> challengeAttemptStats;
    private Integer totalCount;
}
