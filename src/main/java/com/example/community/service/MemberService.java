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

    public MemberDto login(MemberDto memberDto) {
        Optional<Member> optionalMember = memberRepository.findByEmail(memberDto.getEmail());
        if (optionalMember.isPresent()) {
            Member member = optionalMember.get();
            if (member.getPassword().equals(memberDto.getPassword())) {
                // 비밀번호 일치
                return MemberDto.toMemberDto(member);
            } else {
                return null;
            }
        } else {
            // 존재하지 않는 회원
            return null;
        }
    }
}
