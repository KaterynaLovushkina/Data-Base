package com.example.demolab4.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Creater {
    private Integer id;
    private String full_name;
    private String work_branch;
    private String email;
    private Integer created_app_amount;
}
