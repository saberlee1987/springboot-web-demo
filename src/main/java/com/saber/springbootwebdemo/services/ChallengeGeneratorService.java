package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.domains.challenge.Challenge;
import jakarta.servlet.http.HttpServletRequest;

public interface ChallengeGeneratorService {

    Challenge randomChallenge();
}
