package com.arcticfox.algorank.web.dto;

import com.arcticfox.algorank.domain.Member.Member;
import lombok.Getter;

@Getter
public class MemberListResponseDto {

    private Long id;
    private String name;
    private String email;
    private String picture;
    private String role;

    public MemberListResponseDto(Member entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.role = entity.getRoleKey();
    }
}
