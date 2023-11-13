package com.arcticfox.algorank.web;

import com.arcticfox.algorank.config.auth.dto.SessionMember;
import com.arcticfox.algorank.service.MemberService;
import com.arcticfox.algorank.service.ProblemService;
import com.arcticfox.algorank.web.dto.ProblemListResponseDto;
import com.arcticfox.algorank.web.dto.ProblemResponseDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProblemService problemService;
    private final MemberService memberService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("members", memberService.findAllByRank());
        SessionMember member = (SessionMember) httpSession.getAttribute("member");
        if(member != null){
            model.addAttribute("memberName", member.getName());
        }
        return "index";
    }

    @GetMapping("/member/{id}")
    public String memberProblems(@PathVariable Long id, Model model){
        List<ProblemListResponseDto> dto = problemService.findByMemberId(id);
        model.addAttribute("memberProblems", dto);
        return "member-problems";
    }

    @GetMapping("/problem/save")
    public String problemsSave(Model model) {
        SessionMember member = (SessionMember) httpSession.getAttribute("member");
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
