package com.saber.springbootwebdemo.repositories.command.impl;

import com.querydsl.sql.SQLQueryFactory;
import com.saber.springbootwebdemo.domains.command.QUser;
import com.saber.springbootwebdemo.domains.user.command.UserCommand;
import com.saber.springbootwebdemo.repositories.command.UserCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QDSLUserCommandRepository implements UserCommandRepository {

    @Value("${spring.datasource.hikari.schema}")
    private String schema;
    private final SQLQueryFactory sqlQueryFactory;
    private final QUser user = new QUser("user", schema);

    @Override
    public Long saveUser(UserCommand userCommand) {
        return sqlQueryFactory.insert(user).populate(userCommand)
                .executeWithKey(user.id);
    }

    @Override
    public void updateUser(UserCommand userCommand) {
        sqlQueryFactory.update(user).populate(userCommand)
                .where(user.id.eq(userCommand.getId()))
                .execute();
    }

    @Override
    public void deleteUser(Long id) {
        sqlQueryFactory.delete(user)
                .where(user.id.eq(id))
                .execute();
    }
}
