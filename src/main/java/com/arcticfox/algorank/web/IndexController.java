package com.arcticfox.algorank.web;

import com.arcticfox.algorank.service.ProblemService;
import com.arcticfox.algorank.web.dto.ProblemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final ProblemService problemService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/problem/save")
    public String postsSave() {
        return "problem-save";
    }

    @GetMapping("/problem/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        ProblemResponseDto dto = problemService.findById(id);
        model.addAttribute("problem", dto);
        return "problem-update";
    }
}
