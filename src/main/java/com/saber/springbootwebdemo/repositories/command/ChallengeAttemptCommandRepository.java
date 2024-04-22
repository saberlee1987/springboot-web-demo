package com.saber.springbootwebdemo.repositories.command;

import com.saber.springbootwebdemo.domains.challenge.command.ChallengeAttemptCommand;

public interface ChallengeAttemptCommandRepository {
    Long saveChallengeAttempt(ChallengeAttemptCommand challengeAttemptCommand);
    void updateChallengeAttempt(ChallengeAttemptCommand challengeAttemptCommand);
    void deleteChallengeAttemptById(Long id);
}