package com.arcticfox.algorank.web.dto;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.problem.Problem;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberProblemsResponseDto {

    private Long id;
    private List<Problem> problems;

    public MemberProblemsResponseDto(Member entity){
        this.id = entity.getId();
        this.problems = entity.getProblems();

    }
}
