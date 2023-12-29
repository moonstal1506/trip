package com.example.trip.domain.attraction.entity;

import com.example.trip.domain.attraction.dto.request.AttractionUpdateRequestDto;
import com.example.trip.domain.attraction.dto.response.AttractionResponseDto;
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

    @Column(nullable = false, length = 10)
    private String city;

    public AttractionResponseDto toAttractionResponseDto() {
        return AttractionResponseDto.builder()
                .attractionId(attractionId)
                .title(title)
                .description(description)
                .city(city)
                .build();
    }

    public void update(AttractionUpdateRequestDto attractionUpdateRequestDto) {
        this.description = attractionUpdateRequestDto.getDescription();
        this.city = attractionUpdateRequestDto.getCity();
    }
}
