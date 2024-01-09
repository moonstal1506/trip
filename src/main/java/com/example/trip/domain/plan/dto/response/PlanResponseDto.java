package com.example.trip.domain.plan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class PlanResponseDto {

    private Long planId;

    private LocalDateTime date;

    private String memo;

    private List<PlanAttractionResponseDto> attractionResponseList;

}
