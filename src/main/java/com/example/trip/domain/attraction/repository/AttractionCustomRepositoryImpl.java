package com.example.trip.domain.attraction.repository;

import com.example.trip.domain.attraction.dto.request.AttractionRequestDto;
import com.example.trip.domain.attraction.entity.Attraction;
import com.example.trip.domain.attraction.entity.QAttraction;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class AttractionCustomRepositoryImpl implements AttractionCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QAttraction attraction = QAttraction.attraction;

    @Override
    public Page<Attraction> findAttraction(Pageable pageable, AttractionRequestDto attractionRequestDto) {
        List<Attraction> attractions = jpaQueryFactory
                .selectFrom(attraction)
                .where(titleByLike(attractionRequestDto.getTitle()), cityEq(attractionRequestDto.getCity()))
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        Long count = jpaQueryFactory
                .select(attraction.count())
                .from(attraction)
                .where(titleByLike(attractionRequestDto.getTitle()), cityEq(attractionRequestDto.getCity()))
                .fetchOne();

        return new PageImpl<>(attractions, pageable, count);
    }

    private BooleanExpression titleByLike(String title) {
        return title != null ? attraction.title.like("%" + title + "%") : null;
    }

    private BooleanExpression cityEq(String city) {
        return city != null ? attraction.city.eq(city) : null;
    }

}
