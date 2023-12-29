package com.example.trip.domain.member.service;

import com.example.trip.domain.member.dto.request.MemberCreateRequestDto;
import com.example.trip.domain.member.dto.response.MemberResponseDto;
import com.example.trip.domain.member.entity.Member;
import com.example.trip.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void createMember(MemberCreateRequestDto memberCreateRequestDto) {
        validateMember(memberCreateRequestDto);
        Member member = memberCreateRequestDto.createMember();
        memberRepository.save(member);
    }

    private void validateMember(MemberCreateRequestDto memberCreateRequestDto) {
        Member findMember = memberRepository.findByName(memberCreateRequestDto.getName());
        if (findMember != null) {
            throw new IllegalStateException("중복된 이름입니다.");
        }
    }

    public MemberResponseDto findById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);
        return member.toMemberResponseDto();
    }
}
