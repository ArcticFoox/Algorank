package com.arcticfox.algorank.domain.problem;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.Member.MemberRepository;
import com.arcticfox.algorank.domain.Member.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProblemRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ProblemRepository problemRepository;

    @Test
    public void problem_생성(){
        String title = "title";
        String level = "level";
        String content = "content";

        Problem problem = new Problem(title, content, level, Member.builder()
                .name("name")
                .email("jong@naver.com")
                .picture("1.png")
                .build());

        assertThat(problem.getTitle()).isEqualTo(title);
        assertThat(problem.getContent()).isEqualTo(content);
        assertThat(problem.getMember().getName()).isEqualTo("name");
    }

    @Test
    public void problemlist_확인(){
        //given
        String title1 = "t1";
        String content1 = "c1";
        String level1 = "l1";

        String title2 = "t2";
        String content2 = "c2";
        String level2 = "l2";

        Member member = Member.builder()
                .name("shin")
                .email("email")
                .picture("1.png")
                .role(Role.USER)
                .build();

        Problem problem = Problem.builder()
                .title(title1)
                .level(level1)
                .content(content1)
                .member(member)
                .build();

        Problem problem1 = Problem.builder()
                .title(title2)
                .level(level2)
                .content(content2)
                .member(member)
                .build();

        //when
        memberRepository.save(member);
        problemRepository.save(problem);
        problemRepository.save(problem1);
        member.addProblem(problem);
        member.addProblem(problem1);

        //then
        List<Problem> dto = problemRepository.findByMemberId(member.getId());
        assertThat(dto.get(0).getTitle()).isEqualTo(title1);
    }
}