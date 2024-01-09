package com.example.trip.domain.plan.controller;

import com.example.trip.domain.plan.dto.request.PlanCreateRequestDto;
import com.example.trip.domain.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/plan")
@RequiredArgsConstructor
@RestController
public class PlanController {

    private final PlanService planService;

    @PostMapping
    public ResponseEntity<?> createPlan(@RequestBody PlanCreateRequestDto planCreateRequestDto) {
        return new ResponseEntity<>(planService.createPlan(planCreateRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findPlans(@PageableDefault(size = 2) Pageable pageable) {
        return new ResponseEntity<>(planService.findPlanList(pageable), HttpStatus.OK);
    }

    @GetMapping("/{planId}")
    public ResponseEntity<?> findById(@PathVariable Long planId) {
        return new ResponseEntity<>(planService.findById(planId), HttpStatus.OK);
    }
}
