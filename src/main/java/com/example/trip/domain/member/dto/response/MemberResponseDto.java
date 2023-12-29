package com.example.trip.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class MemberResponseDto {

    private Long memberId;

    private String name;

    private String email;

}
