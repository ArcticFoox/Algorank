package com.arcticfox.algorank.domain.Member;

import com.arcticfox.algorank.domain.problem.Problem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void Member_생성(){
        //given
        String name = "name";
        String email = "jong@naver.com";
        String picture = "1.png";

        memberRepository.save(Member.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .build());

        //when
        List<Member> memberList = memberRepository.findAll();

        //then

        Member members = memberList.get(0);

        assertThat(members.getName()).isEqualTo(name);
        assertThat(members.getEmail()).isEqualTo(email);
        assertThat(members.getPicture()).isEqualTo(picture);

    }

    @Test
    public void Member_갱신(){
        //given
        String name = "name";
        String email = "jong@naver.com";
        String picture = "1.png";

        Member member = new Member(name, email, picture);

        String name2 = "name2";
        String picture2 = "2.png";

        //when
        member.update(name2, picture2);

        //then
        assertThat(member.getName()).isEqualTo(name2);
        assertThat(member.getPicture()).isEqualTo(picture2);
    }

    @Test
    public void Member_Problem_추가(){
        //given
        String name = "name";
        String email = "jong@naver.com";
        String picture = "1.png";

        Member member = Member.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .build();

        //when
        Problem problem1 = Problem.builder()
                .title("title")
                .content("content")
                .member(member)
                .build();

        Problem problem2 = Problem.builder()
                .title("title2")
                .content("content2")
                .member(member)
                .build();

        member.addProblem(problem1);
        member.addProblem(problem2);

        //then

        assertThat(member.getProblems().get(0).getTitle()).isEqualTo("title");
        assertThat(member.getProblems().get(1).getTitle()).isEqualTo("title2");
    }
}