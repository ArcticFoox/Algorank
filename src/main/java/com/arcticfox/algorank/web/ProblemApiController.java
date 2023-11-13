package com.arcticfox.algorank.web;

import com.arcticfox.algorank.service.MemberService;
import com.arcticfox.algorank.service.ProblemService;
import com.arcticfox.algorank.web.dto.ProblemResponseDto;
import com.arcticfox.algorank.web.dto.ProblemSaveRequestDto;
import com.arcticfox.algorank.web.dto.ProblemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProblemApiController {

    private final ProblemService problemService;
    private final MemberService memberService;

    @PostMapping("/api/v1/problem")
    public Long save(@RequestBody ProblemSaveRequestDto requestDto) {
        return problemService.save(requestDto);
    }

    @PutMapping("/api/v1/problem/{id}")
    public Long update(@PathVariable Long id, @RequestBody
    ProblemUpdateRequestDto requestDto){
        return problemService.update(id, requestDto);
    }

    @GetMapping("/api/v1/problem/{id}")
    public ProblemResponseDto findById(@PathVariable Long id){ return problemService.findById(id); }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        problemService.delete(id);
        return id;
    }
}
