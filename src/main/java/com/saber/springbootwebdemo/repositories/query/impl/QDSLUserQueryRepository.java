package com.saber.springbootwebdemo.repositories.query.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.saber.springbootwebdemo.domains.user.query.User;
import com.saber.springbootwebdemo.repositories.query.UserQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import static com.saber.springbootwebdemo.domains.user.query.QUser.user;

@Repository
@RequiredArgsConstructor
public class QDSLUserQueryRepository implements UserQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public Optional<User> findByAlias(String alias) {
        return Optional.ofNullable(
                jpaQueryFactory.selectFrom(user)
                        .where(user.alias.eq(alias))
                        .fetchOne()
        );
    }
}
