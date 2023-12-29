package com.example.trip.domain.member.entity;

import com.example.trip.domain.member.dto.request.MemberUpdateRequestDto;
import com.example.trip.domain.member.dto.response.MemberResponseDto;
import com.example.trip.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    public MemberResponseDto toMemberResponseDto() {
        return MemberResponseDto.builder()
                .memberId(memberId)
                .email(email)
                .name(name)
                .build();
    }

    public void update(MemberUpdateRequestDto memberUpdateRequestDto) {
        this.email = memberUpdateRequestDto.getEmail();
        this.password = memberUpdateRequestDto.getPassword();
    }
}
