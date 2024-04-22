package com.saber.springbootwebdemo;

import com.saber.springbootwebdemo.domains.challenge.query.Challenge;
import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeGeneratorService;
import com.saber.springbootwebdemo.services.ChallengeService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Random;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ChallengeServiceTest {
    @Autowired
    private ChallengeGeneratorService challengeGeneratorService;
    @Autowired
    private ChallengeService challengeService;
    @Spy
    private Random random;
//    @Mock
//    private  MessageSource messageSource;
//    @Mock
//    private  ChallengeAttemptCommandRepository challengeAttemptCommandRepository;
//    @Mock
//    private  UserCommandRepository userCommandRepository;
//    @Mock
//    private  UserQueryRepository userQueryRepository;
//    @Mock
//    private  ChallengeAttemptQueryRepository challengeAttemptQueryRepository;
//    @Mock
//    private  UserMapper userMapper;
//    @Mock
//    private  ChallengeAttemptMapper challengeAttemptMapper;
//    @Mock
//    private  TransactionTemplate transactionTemplate;

//    @BeforeEach
//    public void setup() {
//        challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
//        challengeService = new ChallengeServiceImpl(messageSource,challengeAttemptCommandRepository
//                ,userCommandRepository,userQueryRepository
//                ,challengeAttemptQueryRepository,userMapper
//                ,challengeAttemptMapper,transactionTemplate);
//        BDDMockito.given(userQueryRepository.findByAlias("saber")).willReturn(Optional.of(
//                new User(2L,"saber")
//        ));
//
//        BDDMockito.given(challengeAttemptCommandRepository.saveChallengeAttempt(BDDMockito.any()))
//                .will(AdditionalAnswers.returnsLastArg());
//    }

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
    }
}