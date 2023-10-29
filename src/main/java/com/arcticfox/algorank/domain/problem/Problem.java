package com.arcticfox.algorank.domain.problem;

import com.arcticfox.algorank.domain.BaseTimeEntity;
import com.arcticfox.algorank.domain.Member.Member;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Problem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", updatable = false)
    private Member member;

    @Builder
    public Problem(String title, String content, Member member){
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void setMember(Member member){
        this.member = member;
    }

    public Problem update(String title, String content){
        this.title = title;
        this.content = content;

        return this;
    }
}
