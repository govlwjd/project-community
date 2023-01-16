package com.example.community.service;

import com.example.community.domain.Member;
import com.example.community.dto.MemberDto;
import com.example.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public boolean register(MemberDto memberDto) {

        // 이메일 중복 체크
        Optional<Member> optionalMember = memberRepository.findByEmail(memberDto.getEmail());
        if (optionalMember.isPresent()) {
            return false;
        }

        Member member = Member.toEntity(memberDto);
        memberRepository.save(member);
        return true;
    }
}
