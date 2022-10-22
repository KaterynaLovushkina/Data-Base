package com.example.demolab4.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String password_hash;
    private String full_name;
    private String country;
    private String email;
}
