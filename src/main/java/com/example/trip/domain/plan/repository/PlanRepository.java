package com.example.trip.domain.plan.repository;

import com.example.trip.domain.plan.entity.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    // JPQL
//    @Query("SELECT p FROM Plan p JOIN FETCH p.member")
//    Page<Plan> findAllWithMember(Pageable pageable);

    // EntityGraph
    @EntityGraph(attributePaths = "member")
    Page<Plan> findAll(Pageable pageable);
}
