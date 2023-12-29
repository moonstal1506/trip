package com.example.trip.domain.member.dto.request;

import com.example.trip.domain.member.entity.Member;
import lombok.Data;

@Data
public class MemberCreateRequestDto {

    private String name;

    private String email;

    private String password;

    public Member createMember() {
        return Member.builder()
                .name(this.name)
                .email(this.email)
                .password(this.password)
                .build();
    }
}
