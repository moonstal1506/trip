package com.example.trip.domain.plan.dto.request;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlanUpdateRequestDto {

    private Long planId;

    private String title;

    private LocalDateTime date;

    private String memo;

    private List<Long> attractionIdList;

}
