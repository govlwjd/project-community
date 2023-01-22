package com.example.community.controller;

import com.example.community.dto.MemberDto;
import com.example.community.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpl memberServiceImpl;

    // 회원가입
    @GetMapping("/join")
    public String joinForm(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "member/join";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberDto memberDto) {
        memberServiceImpl.join(memberDto);
        return "redirect:/";
    }

    // 로그인
    @RequestMapping("/login")
    public String login() {
        return "member/login";
    }
}
