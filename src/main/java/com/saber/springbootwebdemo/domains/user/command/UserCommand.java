package com.saber.springbootwebdemo.domains.user.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCommand implements Serializable {
    private Long id;
    private String alias;
}