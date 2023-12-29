package com.example.trip.domain.member.service;

import com.example.trip.domain.member.dto.request.MemberCreateRequestDto;
import com.example.trip.domain.member.entity.Member;
import com.example.trip.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(MemberCreateRequestDto memberCreateRequestDto) {
        Member member = memberCreateRequestDto.createMember();
        memberRepository.save(member);
    }
}
