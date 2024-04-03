package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.domains.challenge.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeService;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttempt) {

        Integer factorA = challengeAttempt.getFactorA();
        Integer factorB = challengeAttempt.getFactorB();
        Integer correctResult = factorA * factorB;
        Integer guess = challengeAttempt.getGuess();
        boolean isCorrect = correctResult.equals(guess);

        return new ChallengeAttempt(null,null
                ,challengeAttempt.getAlias(),factorA,factorB,correctResult,isCorrect);
    }
}
