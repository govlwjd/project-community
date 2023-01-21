package com.example.community.dto;

import com.example.community.domain.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private int hits;

    private LocalDateTime regDt;
    private LocalDateTime updDt;


    public static BoardDto toDto(BoardEntity boardEntity) {
        return BoardDto.builder()
                        .id(boardEntity.getId())
                        .title(boardEntity.getTitle())
                        .content(boardEntity.getContent())
                        .writer(boardEntity.getWriter())
                        .hits(boardEntity.getHits())
                        .regDt(boardEntity.getRegDt())
                        .updDt(boardEntity.getUpdDt())
                        .build();
    }
}
