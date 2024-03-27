package com.saber.springbootwebdemo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

@Configuration
public class AppConfig {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource =
                                new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("validationMessages","messages");
        messageSource.setCacheMillis(-1);
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        return messageSource;
    }
}
