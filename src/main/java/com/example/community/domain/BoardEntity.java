package com.example.community.domain;

import com.example.community.dto.BoardDto;
import lombok.*;

import javax.persistence.*;

@Entity(name = "BOARD")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String writer;
    private int hits;

    public static BoardEntity toEntity(BoardDto boardDto) {
        return BoardEntity.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .writer(boardDto.getWriter())
                .hits(0)
                .build();
    }
}
