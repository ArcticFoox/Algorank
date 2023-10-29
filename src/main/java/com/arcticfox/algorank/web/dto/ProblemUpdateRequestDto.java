package com.arcticfox.algorank.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProblemUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public ProblemUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
