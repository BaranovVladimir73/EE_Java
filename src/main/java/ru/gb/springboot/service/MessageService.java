package ru.gb.springboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;
import ru.gb.springboot.MessageProvider;
import ru.gb.springboot.entity.Message;
import ru.gb.springboot.repository.MessageRepository;


import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public Message save(Message message){
        return messageRepository.save(message);
    }

    public Message edit(Message message){
        return messageRepository.edit(message);
    }

    public Message findById(Integer id){
       return messageRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    public void deleteById(Integer id){
        messageRepository.deleteById(id);
    }

    public Message getRandomMessage(){
        return Message.builder()
                .body(getMessageProvider().getMessage())
                .from("Randomizer")
                .to("Browser")
                .build();
    }

    @Lookup
    public MessageProvider getMessageProvider(){
        return null;
    }
}
