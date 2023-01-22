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

    // 게시글 등록
    @GetMapping("/register")
    public String registerForm(@ModelAttribute("boardDto") BoardDto boardDto) {
        return "board/register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute BoardDto boardDto) {
        boardService.register(boardDto);
        return "redirect:/board";
    }

    // 게시글 목록
    @GetMapping("")
    public String postList(Model model) {
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }

    // 게시글 상세보기
    @GetMapping("/{id}")
    public String postDetail(@PathVariable Long id, Model model) {
        // 해당 게시글의 조회수 + 1
        boardService.updateHits(id);
        // 해당 게시글의 데이터를 가져와서 출력한다.
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "board/detail";
    }

    // 게시글 수정
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("boardUpdate", boardDto);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute BoardDto boardDto, Model model) {
        BoardDto editedDto = boardService.edit(boardDto);
        model.addAttribute("board", editedDto);
        return "redirect:/board";
    }
}
