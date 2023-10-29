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
    private Member member;

    @Builder
    public ProblemSaveRequestDto(String title, String content, Member member){
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public Problem toEntity(){
        return Problem.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();
    }
}
