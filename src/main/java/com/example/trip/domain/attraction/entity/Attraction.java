package com.example.trip.domain.attraction.entity;

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
public class Attraction extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attractionId;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String description;

}
