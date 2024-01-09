package com.example.trip.domain.plan.service;

import com.example.trip.domain.attraction.entity.Attraction;
import com.example.trip.domain.attraction.repository.AttractionRepository;
import com.example.trip.domain.member.entity.Member;
import com.example.trip.domain.member.repository.MemberRepository;
import com.example.trip.domain.plan.dto.request.PlanCreateRequestDto;
import com.example.trip.domain.plan.dto.response.PlanListResponseDto;
import com.example.trip.domain.plan.dto.response.PlanResponseDto;
import com.example.trip.domain.plan.entity.Plan;
import com.example.trip.domain.plan.entity.PlanAttraction;
import com.example.trip.domain.plan.repository.PlanAttractionRepository;
import com.example.trip.domain.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class PlanService {

    private final PlanRepository planRepository;
    private final MemberRepository memberRepository;
    private final AttractionRepository attractionRepository;
    private final PlanAttractionRepository planAttractionRepository;

    public Long createPlan(PlanCreateRequestDto planCreateRequestDto) {
        // 회원 엔티티 찾기
        Member member = memberRepository
                .findById(planCreateRequestDto.getMemberId())
                .orElseThrow(IllegalArgumentException::new);

        // 계획 생성
        Plan plan = planCreateRequestDto.createPlan(member);
        planRepository.save(plan);

        // 계획에 들어가는 여행지 저장
        List<PlanAttraction> planAttractions = new ArrayList<>();
        for (Long attractionId : planCreateRequestDto.getAttractionIdList()) {
            Attraction attraction = attractionRepository
                    .findById(attractionId)
                    .orElseThrow(IllegalArgumentException::new);

            PlanAttraction planAttraction = PlanAttraction.create(plan, attraction);
            planAttractions.add(planAttraction);
        }
        planAttractionRepository.saveAll(planAttractions);

        return plan.getPlanId();
    }

    public Page<PlanListResponseDto> findPlanList(Pageable pageable) {
        return planRepository.findAll(pageable)
                .map(plan -> plan.toPlanListResponseDto());
    }

    @Transactional(readOnly = true)
    public PlanResponseDto findById(Long planId) {
        Plan plan = planRepository.findById(planId).orElseThrow(IllegalArgumentException::new);
        return plan.toPlanResponseDto();
    }
}
