package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.domains.user.query.User;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import java.util.Locale;
@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private  MessageSource messageSource;

    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttempt ) {
        Integer factorA = challengeAttempt.getFactorA();
        Integer factorB = challengeAttempt.getFactorB();
        Integer correctResult =factorA * factorB;
        Integer guess = challengeAttempt.getGuess();
        boolean isCorrect = correctResult.equals(guess);
        User user = new User(null, challengeAttempt.getAlias());
        return new ChallengeAttempt(null,user, factorA, factorB, correctResult, isCorrect);
    }

    private String getMessageBundle(String message, Object... params) {
        return messageSource.getMessage(message, params, new Locale("fa"));
    }
}
