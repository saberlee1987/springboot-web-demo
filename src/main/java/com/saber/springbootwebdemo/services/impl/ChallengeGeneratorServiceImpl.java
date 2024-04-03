package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.domains.challenge.Challenge;
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
        return new Challenge(next(),next());
    }
}