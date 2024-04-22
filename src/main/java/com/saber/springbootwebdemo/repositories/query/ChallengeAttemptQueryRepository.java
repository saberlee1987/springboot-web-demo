package com.saber.springbootwebdemo.repositories.query;

import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;

import java.util.List;
import java.util.Optional;

public interface ChallengeAttemptQueryRepository {
    Optional<ChallengeAttempt> findById(Long id);
    List<ChallengeAttempt> findTop10ByUserId(Long userId);
}
