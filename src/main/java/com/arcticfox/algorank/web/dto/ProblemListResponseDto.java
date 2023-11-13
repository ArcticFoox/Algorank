package com.arcticfox.algorank.web.dto;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.problem.Problem;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProblemListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String level;
    private LocalDateTime createdDate;
    private Member member;

    public ProblemListResponseDto(Problem entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.level = entity.getLevel();
        this.createdDate = entity.getCreatedDate();
        this.member = entity.getMember();
    }
}
