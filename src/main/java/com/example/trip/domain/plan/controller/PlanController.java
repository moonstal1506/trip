package com.example.trip.domain.plan.controller;

import com.example.trip.domain.plan.dto.request.PlanCreateRequestDto;
import com.example.trip.domain.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/plan")
@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public ResponseEntity<?> createAttraction(@RequestBody PlanCreateRequestDto planCreateRequestDto) {
        return new ResponseEntity<>(planService.createPlan(planCreateRequestDto), HttpStatus.CREATED);
    }

}
