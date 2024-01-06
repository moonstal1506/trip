package com.example.trip.domain.attraction.repository;

import com.example.trip.domain.attraction.dto.request.AttractionRequestDto;
import com.example.trip.domain.attraction.entity.Attraction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AttractionCustomRepository {

    Page<Attraction> findAttraction(Pageable pageable, AttractionRequestDto attractionRequestDto);
}
