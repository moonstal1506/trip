package com.example.trip.domain.attraction.repository;

import com.example.trip.domain.attraction.entity.Attraction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, Long> {
}
