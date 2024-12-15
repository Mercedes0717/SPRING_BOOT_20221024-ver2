
package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/member_login")
    public String memberLogin(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "exception", required = false) String exception,
                              Model model) {
        if (error != null) {
            model.addAttribute("error", "로그인에 실패했습니다.");
            model.addAttribute("exception", exception);
        }
        return "login";
    }
}
