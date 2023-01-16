package com.example.community.controller;

import com.example.community.dto.MemberDto;
import com.example.community.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @GetMapping("/member/join")
    public String joinForm(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "member/join";
    }

    @PostMapping("/member/join")
    public String join(@ModelAttribute MemberDto memberDto) {
        memberService.register(memberDto);
        return "redirect:/";
    }
}
