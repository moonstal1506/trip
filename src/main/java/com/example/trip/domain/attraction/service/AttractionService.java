package com.example.trip.domain.attraction.service;

import com.example.trip.domain.attraction.dto.request.AttractionCreateRequestDto;
import com.example.trip.domain.attraction.dto.request.AttractionRequestDto;
import com.example.trip.domain.attraction.dto.request.AttractionUpdateRequestDto;
import com.example.trip.domain.attraction.dto.response.AttractionResponseDto;
import com.example.trip.domain.attraction.entity.Attraction;
import com.example.trip.domain.attraction.repository.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class AttractionService {

    private final AttractionRepository attractionRepository;

    public void createAttraction(AttractionCreateRequestDto attractionCreateRequestDto) {
        attractionRepository.save(attractionCreateRequestDto.createAttraction());
    }

    @Transactional(readOnly = true)
    public AttractionResponseDto findById(Long attractionId) {
        Attraction attraction = attractionRepository.findById(attractionId).orElseThrow(IllegalArgumentException::new);
        return attraction.toAttractionResponseDto();
    }

    public AttractionResponseDto updateAttraction(Long attractionId, AttractionUpdateRequestDto attractionUpdateRequestDto) {
        Attraction attraction = attractionRepository.findById(attractionId).orElseThrow(IllegalArgumentException::new);
        attraction.update(attractionUpdateRequestDto);
        return attraction.toAttractionResponseDto();
    }

    public void delete(Long attractionId) {
        attractionRepository.deleteById(attractionId);
    }

    public Page<AttractionResponseDto> findAttraction(Pageable pageable, String city, String title) {
        if (title != null && city != null) {
            return attractionRepository.findByCityAndTitleContaining(pageable, city, title).map(attraction -> attraction.toAttractionResponseDto());
        }
        if (title != null) {
            return attractionRepository.findByTitleContaining(pageable, title).map(attraction -> attraction.toAttractionResponseDto());
        }
        if (city != null) {
            return attractionRepository.findByCity(pageable, city).map(attraction -> attraction.toAttractionResponseDto());
        }
        return attractionRepository.findAll(pageable).map(attraction -> attraction.toAttractionResponseDto());
    }


    public Page<AttractionResponseDto> findAttraction(Pageable pageable, AttractionRequestDto attractionRequestDto) {
        return attractionRepository
                .findAttraction(pageable, attractionRequestDto)
                .map(attraction -> attraction.toAttractionResponseDto());
    }
}
