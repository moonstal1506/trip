package com.example.trip.domain.attraction.repository;

import com.example.trip.domain.attraction.entity.Attraction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttractionRepository extends JpaRepository<Attraction, Long>, AttractionCustomRepository {

    Page<Attraction> findByCity(Pageable pageable, String city);

    Page<Attraction> findByTitleContaining(Pageable pageable, String title);

    Page<Attraction> findByCityAndTitleContaining(Pageable pageable, String city, String title);
}
