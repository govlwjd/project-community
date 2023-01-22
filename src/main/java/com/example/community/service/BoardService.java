package com.example.community.service;

import com.example.community.domain.BoardEntity;
import com.example.community.dto.BoardDto;
import com.example.community.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시글 저장
    public void save(BoardDto boardDto) {
        boardRepository.save(BoardEntity.toEntity(boardDto));
    }

    public List<BoardDto> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDto> boardDtoList = boardEntityList.stream()
                                        .map(e -> BoardDto.toDto(e))
                                        .collect(Collectors.toList());
        return boardDtoList;
    }

    @Transactional
    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDto findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            BoardDto boardDto = BoardDto.toDto(boardEntity);
            return boardDto;
        } else {
            return null;
        }
    }
}
