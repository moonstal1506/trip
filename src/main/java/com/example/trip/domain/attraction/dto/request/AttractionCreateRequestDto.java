package com.example.trip.domain.attraction.dto.request;

import com.example.trip.domain.attraction.entity.Attraction;
import lombok.Data;

@Data
public class AttractionCreateRequestDto {

    private String title;

    private String description;

    private String city;

    public Attraction createAttraction() {
        return Attraction.builder()
                .title(this.title)
                .description(this.description)
                .city(this.city)
                .build();
    }
}
