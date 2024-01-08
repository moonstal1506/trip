package com.example.trip.domain.plan.dto.request;

import com.example.trip.domain.member.entity.Member;
import com.example.trip.domain.plan.entity.Plan;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class PlanCreateRequestDto {

    private Long memberId;

    private String title;

    private LocalDateTime date;

    private String memo;

    private List<Long> attractionIdList;

    public Plan createPlan(Member member) {
        return Plan.builder()
                .title(this.title)
                .date(this.date)
                .memo(this.memo)
                .member(member)
                .build();
    }
}
