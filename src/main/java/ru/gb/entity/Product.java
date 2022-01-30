package ru.gb.entity;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private Integer id;
    private String title;
    private double cost;

}
