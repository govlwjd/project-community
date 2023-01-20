package com.example.community.service;

import com.example.community.domain.MemberEntity;
import com.example.community.dto.MemberDto;
import com.example.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public boolean join(MemberDto memberDto) {

        // 이메일 중복 체크
        Optional<MemberEntity> optionalMember = memberRepository.findByEmail(memberDto.getEmail());
        if (optionalMember.isPresent()) {
            return false;
        }

        memberRepository.save(MemberEntity.toEntity(memberDto));
        return true;
    }

    // 로그인
    public MemberDto login(MemberDto memberDto) {
        Optional<MemberEntity> optionalMember = memberRepository.findByEmail(memberDto.getEmail());
        if (optionalMember.isPresent()) {
            MemberEntity memberEntity = optionalMember.get();
            if (memberEntity.getPassword().equals(memberDto.getPassword())) {
                // 비밀번호 일치
                return MemberDto.toDto(memberEntity);
            } else {
                return null;
            }
        } else {
            // 존재하지 않는 회원
            return null;
        }
    }
}
