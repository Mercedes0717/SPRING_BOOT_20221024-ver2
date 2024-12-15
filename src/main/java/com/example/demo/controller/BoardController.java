
package com.example.demo.controller;

import com.example.demo.model.domain.Board;
import com.example.demo.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board_list")
    public String boardList(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");
        model.addAttribute("email", email); // Pass user email to the view
        model.addAttribute("boards", boardService.findAll());
        return "board_list";
    }

    @PostMapping("/api/add_board")
    public String addBoard(@RequestParam String title,
                           @RequestParam String content,
                           HttpSession session) {
        String email = (String) session.getAttribute("email");
        boardService.saveBoard(title, content, email); // Save the logged-in user as the author
        return "redirect:/board_list";
    }
}
