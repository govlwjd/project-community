package com.example.community.controller;

import com.example.community.dto.BoardDto;
import com.example.community.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String findAll(Model model) {
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }
}
