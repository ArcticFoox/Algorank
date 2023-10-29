package com.arcticfox.algorank.domain.problem;

import com.arcticfox.algorank.domain.Member.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProblemRepositoryTest {

    @Test
    public void problem_생성(){
        String title = "title";
        String content = "content";

        Problem problem = new Problem(title, content, Member.builder()
                .name("name")
                .email("jong@naver.com")
                .picture("1.png")
                .build());

        assertThat(problem.getTitle()).isEqualTo(title);
        assertThat(problem.getContent()).isEqualTo(content);
        assertThat(problem.getMember().getName()).isEqualTo("name");
    }
}