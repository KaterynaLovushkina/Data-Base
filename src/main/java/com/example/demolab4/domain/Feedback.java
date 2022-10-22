package com.example.demolab4.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Feedback {
    private Integer id;
    private String description;
    private String created_date;
    private Float rate;
    private Integer user_id;
    private Integer app_id;
}
