package ru.gb;

import org.springframework.stereotype.Component;

@Component
public class HelloSpringMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello Spring";
    }
}
