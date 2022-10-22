package com.example.demolab4.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class App {
    private Integer id;
    private String name;
    private String description;
    private Integer weight_in_mb;
    private String create_date;
    private Boolean is_free;
    private Float price_in_dollars;
    private Boolean has_advert;
    private Integer category_id;
}
