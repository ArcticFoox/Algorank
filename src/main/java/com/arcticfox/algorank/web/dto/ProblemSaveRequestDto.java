package com.arcticfox.algorank.web.dto;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.problem.Problem;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemSaveRequestDto {
    private String title;
    private String content;
    private String level;
    private String memberEmail;

    @Builder
    public ProblemSaveRequestDto(String title, String content, String level, String memberEmail){
        this.title = title;
        this.content = content;
        this.level = level;
        this.memberEmail = memberEmail;
    }

    public Problem toEntity(Member member){
        return Problem.builder()
                .title(title)
                .content(content)
                .level(level)
                .member(member)
                .build();
    }
}
