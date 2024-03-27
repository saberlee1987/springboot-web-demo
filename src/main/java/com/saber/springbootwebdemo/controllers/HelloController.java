package com.saber.springbootwebdemo.controllers;

import com.saber.springbootwebdemo.dto.MessageDto;
import com.saber.springbootwebdemo.services.HelloService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "${service.baseUrl}/hello",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping(value = "/sayHello")
    public ResponseEntity<MessageDto> sayHello(@RequestParam(name = "firstName", required = false)
                                               @NotBlank(message = "{firstName.required}")
                                               String firstName
            , @RequestParam(name = "lastName", required = false)
                                               @NotBlank(message = "{lastName.required}")
                                               String lastName) {
        return ResponseEntity.ok(helloService.sayHello(firstName, lastName));
    }
}