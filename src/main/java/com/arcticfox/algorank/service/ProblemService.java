package com.arcticfox.algorank.service;

import com.arcticfox.algorank.domain.problem.Problem;
import com.arcticfox.algorank.domain.problem.ProblemRepository;
import com.arcticfox.algorank.web.dto.ProblemListResponseDto;
import com.arcticfox.algorank.web.dto.ProblemResponseDto;
import com.arcticfox.algorank.web.dto.ProblemSaveRequestDto;
import com.arcticfox.algorank.web.dto.ProblemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    @Transactional
    public Long save(ProblemSaveRequestDto requestDto) {
        return problemRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProblemUpdateRequestDto requestDto){
        Problem problem = problemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        problem.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public ProblemResponseDto findById(Long id){
        Problem entity = problemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new ProblemResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ProblemListResponseDto> findAllDesc(){
        return problemRepository.findAll().stream()
                .map(ProblemListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Problem problem = problemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        problemRepository.delete(problem);
    }

}
