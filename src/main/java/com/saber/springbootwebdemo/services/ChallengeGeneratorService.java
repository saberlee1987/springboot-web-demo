package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.domains.challenge.query.Challenge;

public interface ChallengeGeneratorService {

    Challenge randomChallenge();
}
