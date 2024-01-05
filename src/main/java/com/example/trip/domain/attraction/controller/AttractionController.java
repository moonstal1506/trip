package com.example.trip.domain.attraction.controller;

import com.example.trip.domain.attraction.dto.request.AttractionCreateRequestDto;
import com.example.trip.domain.attraction.dto.request.AttractionRequestDto;
import com.example.trip.domain.attraction.dto.request.AttractionUpdateRequestDto;
import com.example.trip.domain.attraction.dto.response.AttractionResponseDto;
import com.example.trip.domain.attraction.service.AttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/attraction")
@RequiredArgsConstructor
@RestController
public class AttractionController {

    private final AttractionService attractionService;

    @PostMapping
    public ResponseEntity<?> createAttraction(@RequestBody AttractionCreateRequestDto attractionCreateRequestDto) {
        attractionService.createAttraction(attractionCreateRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{attractionId}")
    public ResponseEntity<?> findById(@PathVariable Long attractionId) {
        return new ResponseEntity<>(attractionService.findById(attractionId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAttraction(
            @PageableDefault(size = 2) Pageable pageable,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String title
    ) {
        System.out.println("title = " + title);
        return new ResponseEntity<>(attractionService.findAttraction(pageable, city, title), HttpStatus.OK);
    }

    @GetMapping("/v2")
    public ResponseEntity<?> findAttraction2(
            @PageableDefault(size = 2) Pageable pageable,
            AttractionRequestDto attractionRequestDto
    ) {
        System.out.println("attractionRequestDto = " + attractionRequestDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PatchMapping("/{attractionId}")
    public ResponseEntity<?> updateAttraction(@PathVariable Long attractionId, @RequestBody AttractionUpdateRequestDto attractionUpdateRequestDto) {
        AttractionResponseDto attractionResponseDto = attractionService.updateAttraction(attractionId, attractionUpdateRequestDto);
        return new ResponseEntity<>(attractionResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{attractionId}")
    public ResponseEntity<?> deleteMember(@PathVariable Long attractionId) {
        attractionService.delete(attractionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
