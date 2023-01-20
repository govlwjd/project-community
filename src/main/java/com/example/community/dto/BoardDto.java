package com.example.community.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private String title;
    private String content;
    private String writer;
    private int hits;
}
