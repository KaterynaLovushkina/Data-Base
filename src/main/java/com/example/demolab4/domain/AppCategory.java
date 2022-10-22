package com.example.demolab4.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppCategory {
    private Integer id;
    private String name;
    private String description;
}
