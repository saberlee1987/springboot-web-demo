package com.saber.springbootwebdemo.mappers;

import com.saber.springbootwebdemo.domains.challenge.command.ChallengeAttemptCommand;
import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDashboard;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.dto.ChallengeAttemptStats;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ChallengeAttemptMapper {

    ChallengeAttemptCommand requestDtoToCommand(ChallengeAttemptDto challengeAttemptDto);

    @Mapping(target = "userAlias",source = "user.alias")
    ChallengeAttemptStats modelToStats(ChallengeAttempt challengeAttempt);
    List<ChallengeAttemptStats> modelToStats( List<ChallengeAttempt> challengeAttempts);
}
