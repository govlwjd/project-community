package com.example.community.domain;

import com.example.community.dto.MemberDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "MEMBER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String memberName;
    private String phone;
    private LocalDateTime regDt;

    public static MemberEntity toEntity(MemberDto memberDto) {
        return MemberEntity.builder()
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .memberName(memberDto.getMemberName())
                .phone(memberDto.getPhone())
                .regDt(LocalDateTime.now())
                .build();
    }
}
