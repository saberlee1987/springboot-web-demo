package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDashboard;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;

import java.util.List;

public interface ChallengeService {
    ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttempt);
    ChallengeAttemptDashboard get10ChallengeAttemptByUserAlias(String alias);
}