package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.domains.challenge.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;

public interface ChallengeService {
    ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttempt);
}