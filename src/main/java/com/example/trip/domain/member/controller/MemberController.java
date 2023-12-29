package com.example.trip.domain.member.controller;

import com.example.trip.domain.member.dto.request.MemberCreateRequestDto;
import com.example.trip.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/member")
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> createMember(@RequestBody MemberCreateRequestDto memberCreateRequestDto){
        memberService.createMember(memberCreateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
