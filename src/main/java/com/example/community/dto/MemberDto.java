package com.example.community.dto;

import com.example.community.domain.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MemberDto {

    private String email;
    private String password;
    private String memberName;
    private String phone;

    public static MemberDto toMemberDto(Member member) {
        return MemberDto.builder()
                .email(member.getEmail())
                .password(member.getPassword())
                .memberName(member.getMemberName())
                .phone(member.getPhone())
                .build();
    }
}
