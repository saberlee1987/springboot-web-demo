package com.saber.springbootwebdemo.services.impl;

import com.saber.springbootwebdemo.dto.MessageDto;
import com.saber.springbootwebdemo.services.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public MessageDto sayHello(String firstName, String lastName) {
        return createMessage("Hello", firstName, lastName);
    }

    @Override
    public MessageDto sayBye(String firstName, String lastName) {
        return createMessage("Bye Bye", firstName, lastName);
    }

    private MessageDto createMessage(String messageText, String firstName, String lastName) {
        log.info("say {} call with parameter firstName {} , lastName {}", messageText, firstName, lastName);
        String message = messageText.concat(" ").concat(firstName).concat(" ").concat(lastName);
        log.info(" response say {}  with parameter firstName {} , lastName {} ===> {}"
                , messageText, firstName, lastName, message);
        return new MessageDto(message);
    }
}
