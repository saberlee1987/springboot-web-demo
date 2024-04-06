package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.domains.challenge.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import jakarta.servlet.http.HttpServletRequest;

public interface ChallengeService {
    ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttempt);
}