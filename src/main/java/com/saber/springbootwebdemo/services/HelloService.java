package com.saber.springbootwebdemo.services;

import com.saber.springbootwebdemo.dto.MessageDto;

public interface HelloService {
    MessageDto sayHello(String firstName , String lastName);
    MessageDto sayBye(String firstName , String lastName);
}