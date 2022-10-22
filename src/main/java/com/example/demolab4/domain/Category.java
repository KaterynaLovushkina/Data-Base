package com.example.demolab4.domain;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Category {
    private Integer id;
    private String audience_type;
    private Integer app_category_id;
}
