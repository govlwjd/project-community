package com.example.community.service;

import com.example.community.domain.BoardEntity;
import com.example.community.dto.BoardDto;
import com.example.community.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 저장
    public void save(BoardDto boardDto) {
        boardRepository.save(BoardEntity.toEntity(boardDto));
    }
}
