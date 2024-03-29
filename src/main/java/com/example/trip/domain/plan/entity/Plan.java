package com.example.trip.domain.plan.entity;

import com.example.trip.domain.member.entity.Member;
import com.example.trip.domain.plan.dto.request.PlanUpdateRequestDto;
import com.example.trip.domain.plan.dto.response.PlanListResponseDto;
import com.example.trip.domain.plan.dto.response.PlanResponseDto;
import com.example.trip.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Plan extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String memo;

    //연관관계 주인은 다쪽에 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanAttraction> planAttractions = new ArrayList<>();

    public PlanListResponseDto toPlanListResponseDto() {
        return PlanListResponseDto.builder()
                .planId(planId)
                .title(title)
                .name(member.getName())
                .createdDate(getCreatedDate())
                .build();
    }

    public PlanResponseDto toPlanResponseDto() {
        return PlanResponseDto.builder()
                .planId(planId)
                .date(date)
                .memo(memo)
                .attractionResponseList(planAttractions
                        .stream()
                        .map(planAttraction -> planAttraction.getAttraction().toPlanAttractionResponseDto())
                        .collect(Collectors.toList()))
                .build();
    }

    public void update(PlanUpdateRequestDto planUpdateRequestDto, List<PlanAttraction> attractionPlan) {
        this.title = planUpdateRequestDto.getTitle();
        this.memo = planUpdateRequestDto.getMemo();
        this.date = planUpdateRequestDto.getDate();

        // 기존의 planAttractions를 제거하고 새로운 attractionPlan을 추가
        this.planAttractions.clear();
        this.planAttractions.addAll(attractionPlan);
    }
}
