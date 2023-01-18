package com.example.community.controller;

import com.example.community.dto.MemberDto;
import com.example.community.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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

    // 로그인
    @GetMapping("/member/login")
    public String loginForm(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "member/login";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
        MemberDto loginResult = memberService.login(memberDto);
        if (loginResult != null) {
            // 로그인 성공
            session.setAttribute("loginEmail", loginResult.getEmail());
            return "redirect:/";
        } else {
            // 로그인 실패
            return "member/login";
        }
    }
}
