package com.arcticfox.algorank.domain.problem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    @Query("select p from Problem p where p.member.id = :id")
    List<Problem> findByMemberId(Long id);
}
