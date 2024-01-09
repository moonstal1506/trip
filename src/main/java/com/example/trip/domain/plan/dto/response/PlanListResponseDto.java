package com.example.trip.domain.plan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class PlanListResponseDto {

    private Long planId;

    private String title;

    private String name;

    private LocalDateTime createdDate;
}
