package com.arcticfox.algorank.web;

import com.arcticfox.algorank.domain.Member.Member;
import com.arcticfox.algorank.domain.Member.MemberRepository;
import com.arcticfox.algorank.domain.Member.Role;
import com.arcticfox.algorank.domain.problem.Problem;
import com.arcticfox.algorank.domain.problem.ProblemRepository;
import com.arcticfox.algorank.web.dto.ProblemSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProblemApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    public void tearDown() throws Exception{
        problemRepository.deleteAll();
    }

    @Test
    public void Problem_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        String level = "level";


        Member member = Member.builder()
                .name("name")
                .email("jong@naver.com")
                .picture("1.png")
                .build();

        memberRepository.save(member);

        ProblemSaveRequestDto requestDto = ProblemSaveRequestDto.builder()
                .title(title)
                .content(content)
                .level(level)
                .build();

        String url = "http://localhost:" + port + "/api/v1/problem";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto.toEntity(member), Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Problem> all = problemRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void Problem_수정된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        String level = "level";

        Member member = Member.builder()
                .name("name")
                .email("jong@naver.com")
                .picture("1.png")
                .role(Role.USER)
                .build();

        memberRepository.save(member);

        ProblemSaveRequestDto requestDto = ProblemSaveRequestDto.builder()
                .title(title)
                .content(content)
                .level(level)
                .build();

        String url = "http://localhost:" + port + "/api/v1/problem";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto.toEntity(member), Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Problem> all = problemRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

}