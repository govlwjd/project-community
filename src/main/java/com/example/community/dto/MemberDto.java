package com.example.community.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {

    private String email;
    private String password;
    private String memberName;
    private String phone;
}
