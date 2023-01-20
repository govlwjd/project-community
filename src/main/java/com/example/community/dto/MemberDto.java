package com.example.community.dto;

import com.example.community.domain.MemberEntity;
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

    public static MemberDto toDto(MemberEntity memberEntity) {
        return MemberDto.builder()
                .email(memberEntity.getEmail())
                .password(memberEntity.getPassword())
                .memberName(memberEntity.getMemberName())
                .phone(memberEntity.getPhone())
                .build();
    }
}
