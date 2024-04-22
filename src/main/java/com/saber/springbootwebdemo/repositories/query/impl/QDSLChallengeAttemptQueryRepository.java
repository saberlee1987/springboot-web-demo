package com.saber.springbootwebdemo.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.repositories.query.ChallengeAttemptQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.saber.springbootwebdemo.domains.challenge.query.QChallengeAttempt.challengeAttempt;

@Repository
@RequiredArgsConstructor
public class QDSLChallengeAttemptQueryRepository implements ChallengeAttemptQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<ChallengeAttempt> findById(Long id) {
        return Optional.ofNullable(
                jpaQueryFactory.selectFrom(challengeAttempt)
                        .where(challengeAttempt.id.eq(id))
                        .fetchOne()
        );
    }

    @Override
    public List<ChallengeAttempt> findTop10ByUserId(Long userId) {
        return jpaQueryFactory.selectFrom(challengeAttempt)
                .where(challengeAttempt.user.id.eq(userId))
                .orderBy(challengeAttempt.id.desc())
                .limit(10)
                .fetch();
    }
}
