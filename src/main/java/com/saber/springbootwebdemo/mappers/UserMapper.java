package com.saber.springbootwebdemo.mappers;

import com.saber.springbootwebdemo.domains.user.command.UserCommand;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserCommand requestDtoToCommand(ChallengeAttemptDto challengeAttemptDto);
}
