package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.domains.challenge.Challenge;

public interface ChallengeGeneratorService {

    Challenge randomChallenge();
}
