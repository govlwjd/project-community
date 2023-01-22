package com.example.community.service;

import com.example.community.dto.MemberDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean join(MemberDto memberDto);
}
