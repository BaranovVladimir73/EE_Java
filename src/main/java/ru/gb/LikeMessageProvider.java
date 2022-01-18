package ru.gb;

import org.springframework.stereotype.Component;

@Component
public class LikeMessageProvider implements MessageProvider {

    @InjectFoodStuff
    String stuff;

    @Override
    public String getMessage() {
        return "I like " + stuff;
    }
}
