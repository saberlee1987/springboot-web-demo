package com.saber.springbootwebdemo;

import com.saber.springbootwebdemo.domains.challenge.Challenge;
import com.saber.springbootwebdemo.domains.challenge.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeGeneratorService;
import com.saber.springbootwebdemo.services.ChallengeService;
import com.saber.springbootwebdemo.services.impl.ChallengeGeneratorServiceImpl;
import com.saber.springbootwebdemo.services.impl.ChallengeServiceImpl;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

@ExtendWith(MockitoExtension.class)
public class ChallengeServiceTest {
    private ChallengeGeneratorService challengeGeneratorService;
    private ChallengeService challengeService;
    @Spy
    private Random random;

    @BeforeEach
    public void setup() {
        challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
        challengeService = new ChallengeServiceImpl();
    }

    @Test
    public void generateRandomFactorIsBetweenExceptedLimits() {
        BDDMockito.given(random.nextInt(89)).willReturn(20, 30);
        Challenge challenge = challengeGeneratorService.randomChallenge();
        BDDAssertions.then(challenge).isEqualTo(new Challenge(31, 41));
    }

    @Test
    public void checkCorrectAttemptTest() {
        ChallengeAttemptDto attemptDto = new ChallengeAttemptDto(
                50, 60, "saber", 3000);
        ChallengeAttempt verifyAttempt = challengeService.verifyAttempt(attemptDto);
        BDDAssertions.then(verifyAttempt.getIsCorrect()).isTrue();
    }}