package com.arcticfox.algorank.web.dto;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.problem.Problem;
import lombok.Getter;

@Getter
public class ProblemResponseDto {

    private Long id;
    private String title;
    private String content;
    private String level;
    private Member member;

    public ProblemResponseDto(Problem entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.level = entity.getLevel();
        this.member = entity.getMember();
    }
}
