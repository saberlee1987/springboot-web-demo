package com.saber.springbootwebdemo.repositories.command;

import com.saber.springbootwebdemo.domains.user.command.UserCommand;

public interface UserCommandRepository {
    Long saveUser(UserCommand userCommand);
    void updateUser(UserCommand userCommand);
    void  deleteUser(Long id);
}