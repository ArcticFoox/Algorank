package com.arcticfox.algorank.service;

import com.arcticfox.algorank.domain.Member.MemberRepository;
import com.arcticfox.algorank.web.dto.MemberListResponseDto;
import com.arcticfox.algorank.web.dto.MemberProblemsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

//    @Transactional
//    public Long addProblem(Problem problem){
//        return memberRepository.
//    }

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllByRank(){
        return memberRepository.findAll().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

}
