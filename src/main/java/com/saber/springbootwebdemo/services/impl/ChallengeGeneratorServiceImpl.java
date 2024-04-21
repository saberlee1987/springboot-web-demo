package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.domains.challenge.query.Challenge;
import com.saber.springbootwebdemo.services.ChallengeGeneratorService;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ChallengeGeneratorServiceImpl implements ChallengeGeneratorService {
    private final Random random;
    private static final Integer MINIMUM_FACTOR = 11;
    private static final Integer MAXIMUM_FACTOR = 100;

    public ChallengeGeneratorServiceImpl() {
        this.random = new Random();
    }

    public ChallengeGeneratorServiceImpl(Random random) {
        this.random = random;
    }

    private Integer next(){
        return random.nextInt(MAXIMUM_FACTOR - MINIMUM_FACTOR);
    }
    @Override
    public Challenge randomChallenge() {
        Integer factorA = next();
        Integer factorB = next();
        Challenge challenge = new Challenge(factorA, factorB);
       // HttpSession session = request.getSession(true);
       // session.setAttribute(session.getId(),challenge);
        return challenge;
    }
}
