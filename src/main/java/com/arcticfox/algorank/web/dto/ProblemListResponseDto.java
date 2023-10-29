package com.arcticfox.algorank.web.dto;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.problem.Problem;
import lombok.Getter;

@Getter
public class ProblemListResponseDto {
    private Long id;
    private String title;
    private String content;
    private Member member;

    public ProblemListResponseDto(Problem entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.member = entity.getMember();
    }
}
