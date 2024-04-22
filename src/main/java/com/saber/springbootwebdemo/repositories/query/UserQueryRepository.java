package com.saber.springbootwebdemo.repositories.query;

import com.saber.springbootwebdemo.domains.user.query.User;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserQueryRepository {

    Optional<User> findByAlias(String alias);
}
