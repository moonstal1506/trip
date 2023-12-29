package com.example.trip.domain.attraction.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AttractionResponseDto {

    private Long attractionId;

    private String title;

    private String description;

    private String city;

}
