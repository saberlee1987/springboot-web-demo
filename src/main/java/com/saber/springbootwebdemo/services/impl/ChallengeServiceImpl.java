package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.domains.challenge.command.ChallengeAttemptCommand;
import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.domains.user.command.UserCommand;
import com.saber.springbootwebdemo.domains.user.query.User;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDashboard;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.dto.ChallengeAttemptStats;
import com.saber.springbootwebdemo.mappers.ChallengeAttemptMapper;
import com.saber.springbootwebdemo.mappers.UserMapper;
import com.saber.springbootwebdemo.repositories.command.ChallengeAttemptCommandRepository;
import com.saber.springbootwebdemo.repositories.command.UserCommandRepository;
import com.saber.springbootwebdemo.repositories.query.ChallengeAttemptQueryRepository;
import com.saber.springbootwebdemo.repositories.query.UserQueryRepository;
import com.saber.springbootwebdemo.services.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChallengeServiceImpl implements ChallengeService {

    private final MessageSource messageSource;
    //command
    private final ChallengeAttemptCommandRepository challengeAttemptCommandRepository;
    private final UserCommandRepository userCommandRepository;

    //query
    private final UserQueryRepository userQueryRepository;
    private final ChallengeAttemptQueryRepository challengeAttemptQueryRepository;

    //mapper
    private final UserMapper userMapper;
    private final ChallengeAttemptMapper challengeAttemptMapper;

    private final TransactionTemplate transactionTemplate;

    @Override
    public ChallengeAttempt verifyAttempt(ChallengeAttemptDto challengeAttemptDto) {
        Integer factorA = challengeAttemptDto.getFactorA();
        Integer factorB = challengeAttemptDto.getFactorB();
        Integer correctResult = factorA * factorB;
        Integer guess = challengeAttemptDto.getGuess();
        boolean isCorrect = correctResult.equals(guess);
        String alias = challengeAttemptDto.getAlias();
        Optional<User> userOptional = userQueryRepository.findByAlias(alias);
        Long userId;
        if (userOptional.isPresent()) {
            userId = userOptional.get().getId();
        } else {
            UserCommand userCommand = userMapper.requestDtoToCommand(challengeAttemptDto);
            userId = transactionTemplate.execute(t -> userCommandRepository.saveUser(userCommand));
        }
        ChallengeAttemptCommand challengeAttemptCommand = challengeAttemptMapper.requestDtoToCommand(challengeAttemptDto);
        challengeAttemptCommand.setUserId(userId);
        challengeAttemptCommand.setIsCorrect(isCorrect);
        challengeAttemptCommand.setResultAttempt(guess);
        Long challengeAttemptId = transactionTemplate.execute(
                t -> challengeAttemptCommandRepository.saveChallengeAttempt(challengeAttemptCommand)
        );
        return challengeAttemptQueryRepository.findById(challengeAttemptId).orElse(null);
    }

    @Override
    public ChallengeAttemptDashboard get10ChallengeAttemptByUserAlias(String alias) {
        List<ChallengeAttempt> challengeAttempts = new ArrayList<>();
        Optional<User> userOptional = userQueryRepository.findByAlias(alias);
        if (userOptional.isPresent()) {
            Long userId = userOptional.get().getId();
            challengeAttempts = challengeAttemptQueryRepository.findTop10ByUserId(userId);
        }
        ChallengeAttemptDashboard challengeAttemptDashboard  = new ChallengeAttemptDashboard();
        List<ChallengeAttemptStats> challengeAttemptStats = challengeAttemptMapper.modelToStats(challengeAttempts);
        challengeAttemptDashboard.setChallengeAttemptStats(challengeAttemptStats);
        challengeAttemptDashboard.setTotalCount(challengeAttempts.size());
        return challengeAttemptDashboard;
    }

    private String getMessageBundle(String message, Object... params) {
        return messageSource.getMessage(message, params, new Locale("fa"));
    }
}
