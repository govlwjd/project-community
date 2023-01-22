package com.example.community.service;

import com.example.community.domain.MemberEntity;
import com.example.community.dto.MemberDto;
import com.example.community.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Override
    public boolean join(MemberDto memberDto) {

        // 이메일 중복 체크
        Optional<MemberEntity> optionalMember = memberRepository.findByEmail(memberDto.getEmail());
        if (optionalMember.isPresent()) {
            return false;
        }

        MemberEntity memberEntity = MemberEntity.toEntity(memberDto);
        memberEntity.setPassword(passwordEncoder.encode(memberDto.getPassword()));
        memberRepository.save(memberEntity);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MemberEntity> optionalMember = memberRepository.findByEmail(username);

        if (!optionalMember.isPresent()) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다.");
        }

        MemberEntity memberEntity = optionalMember.get();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(memberEntity.getEmail(), memberEntity.getPassword(), grantedAuthorities);
    }
}
