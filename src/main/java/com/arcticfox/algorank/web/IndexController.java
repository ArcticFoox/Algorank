package com.arcticfox.algorank.web;

import com.arcticfox.algorank.config.auth.LoginMember;
import com.arcticfox.algorank.config.auth.dto.SessionMember;
import com.arcticfox.algorank.service.MemberService;
import com.arcticfox.algorank.service.ProblemService;
import com.arcticfox.algorank.web.dto.ProblemListResponseDto;
import com.arcticfox.algorank.web.dto.ProblemResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProblemService problemService;
    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model, @LoginMember SessionMember member){
        model.addAttribute("members", memberService.findAllByRank());
        if(member != null){
            model.addAttribute("memberName", member.getName());
        }
        return "index";
    }

//    @GetMapping("/rank/day/{year}/{month}/{day}")
//    public String dayRank(@PathVariable LocalDateTime year)

    @GetMapping("/member/{id}")
    public String memberProblems(@PathVariable Long id, Model model){
        List<ProblemListResponseDto> dto = problemService.findByMemberId(id);
        model.addAttribute("memberProblems", dto);
        return "member-problems";
    }

    @GetMapping("/problem/save")
    public String problemsSave(Model model, @LoginMember SessionMember member) {
        if(member != null){
            model.addAttribute("memberInfo", member);
        }
        return "problem-save";
    }

    @GetMapping("/problem/update/{id}")
    public String problemsUpdate(@PathVariable Long id, Model model) {
        ProblemResponseDto dto = problemService.findById(id);
        model.addAttribute("problem", dto);
        return "problem-update";
    }
}
