package com.example.community.domain;

import com.example.community.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String memberName;
    private String phone;
    private LocalDateTime regDt;

    public static Member toEntity(MemberDto memberDto) {
        return Member.builder()
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .memberName(memberDto.getMemberName())
                .phone(memberDto.getPhone())
                .regDt(LocalDateTime.now())
                .build();
    }
}
