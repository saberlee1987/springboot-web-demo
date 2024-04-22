package com.saber.springbootwebdemo.repositories.command.impl;

import com.querydsl.sql.SQLQueryFactory;
import com.saber.springbootwebdemo.domains.challenge.command.ChallengeAttemptCommand;
import com.saber.springbootwebdemo.domains.command.QChallengeattempt;
import com.saber.springbootwebdemo.repositories.command.ChallengeAttemptCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class QDSLChallengeAttemptCommandRepository implements ChallengeAttemptCommandRepository {

    private final SQLQueryFactory sqlQueryFactory;

    @Value("${spring.datasource.hikari.schema}")
    private String schema;
    private final QChallengeattempt challengeAttempt = new QChallengeattempt("qChallengeCommand",schema);

    @Override
    public Long saveChallengeAttempt(ChallengeAttemptCommand challengeAttemptCommand) {
        return sqlQueryFactory.insert(challengeAttempt).populate(challengeAttemptCommand)
                .executeWithKey(challengeAttempt.id);

        //return null;
    }

    @Override
    public void updateChallengeAttempt(ChallengeAttemptCommand challengeAttemptCommand) {
         sqlQueryFactory.update(challengeAttempt).populate(challengeAttemptCommand)
                 .where(challengeAttempt.id.eq(challengeAttemptCommand.getId()))
                .execute();

    }

    @Override
    public void deleteChallengeAttemptById(Long id) {
        sqlQueryFactory.delete(challengeAttempt)
                .where(challengeAttempt.id.eq(id))
                .execute();
    }
}
