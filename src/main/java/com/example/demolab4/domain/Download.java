package com.example.demolab4.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Download {
    private Integer id;
    private Integer amount;
    private Float total_price;
    private Integer user_id;
}
