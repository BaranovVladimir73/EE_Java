package ru.gb.springboot.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private Integer id;
    private String body;
    private String to;
    private String from;


}
