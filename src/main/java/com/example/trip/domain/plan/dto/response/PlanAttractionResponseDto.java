package com.example.trip.domain.plan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class PlanAttractionResponseDto {

    private Long attractionId;

    private String title;

    private String city;

}
