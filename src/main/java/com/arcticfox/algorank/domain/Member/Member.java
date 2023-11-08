package com.arcticfox.algorank.domain.Member;

import com.arcticfox.algorank.domain.problem.Problem;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Problem> problems = new ArrayList<>();

    @Builder
    public Member(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public Member update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public void addProblem(Problem problem){
        problem.setMember(this);
        problems.add(problem);

    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
