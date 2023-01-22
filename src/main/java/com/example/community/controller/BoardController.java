package com.example.community.controller;

import com.example.community.dto.BoardDto;
import com.example.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 저장
    @GetMapping("/save")
    public String saveForm(@ModelAttribute("boardDto") BoardDto boardDto) {
        return "board/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDto boardDto) {
        boardService.save(boardDto);
        return "redirect:/board/";
    }

    // 게시글 목록
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }

    // 게시글 상세보기
    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        // 해당 게시글의 조회수 + 1
        boardService.updateHits(id);
        // 해당 게시글의 데이터를 가져와서 출력한다.
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "board/detail";
    }
}
