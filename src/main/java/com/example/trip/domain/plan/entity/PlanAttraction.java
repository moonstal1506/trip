package com.example.trip.domain.plan.entity;

import com.example.trip.domain.attraction.entity.Attraction;
import com.example.trip.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlanAttraction extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planAttractionId;

    //연관관계 주인은 다쪽에 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attraction_id", nullable = false)
    private Attraction attraction;

    public static PlanAttraction create(Plan plan, Attraction attraction) {
        return PlanAttraction.builder()
                .plan(plan)
                .attraction(attraction)
                .build();
    }
}
