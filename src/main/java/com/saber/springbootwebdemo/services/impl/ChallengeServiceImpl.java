package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.domains.challenge.Challenge;
import com.saber.springbootwebdemo.domains.challenge.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.BusinessException;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttempt
           // , HttpServletRequest request
    ) {
        Integer factorA = challengeAttempt.getFactorA();
        Integer factorB = challengeAttempt.getFactorB();
        Integer correctResult =factorA * factorB;
        Integer guess = challengeAttempt.getGuess();
        boolean isCorrect = correctResult.equals(guess);
        return new ChallengeAttempt(null, null
                , challengeAttempt.getAlias(), factorA, factorB, correctResult, isCorrect);


//        HttpSession session = request.getSession(true);
//        if (session.getAttribute(session.getId()) == null) {
//            throw new BusinessException(getMessageBundle("challenge.first.call.random.numbers"));
//        }
//        Object challengeSession = session.getAttribute(session.getId());
//        if (challengeSession instanceof Challenge challenge) {
//            Integer factorA = challengeAttempt.getFactorA();
//            Integer factorB = challengeAttempt.getFactorB();
//            if (!challenge.getFactorA().equals(factorA) || !challenge.getFactorB().equals(factorB)) {
//                throw new BusinessException(getMessageBundle("challenge.numbers.before.call.notEqual.numbers.entered"));
//            }
//            Integer correctResult = challenge.getFactorA() * challenge.getFactorB();
//            Integer guess = challengeAttempt.getGuess();
//            boolean isCorrect = correctResult.equals(guess);
//            session.setAttribute(session.getId(), null);
//            return new ChallengeAttempt(null, null
//                    , challengeAttempt.getAlias(), factorA, factorB, correctResult, isCorrect);
//        } else {
//            throw new BusinessException(getMessageBundle("challenge.first.call.random.numbers"));
//        }
    }

    private String getMessageBundle(String message, Object... params) {
        return messageSource.getMessage(message, params, new Locale("fa"));
    }
}
