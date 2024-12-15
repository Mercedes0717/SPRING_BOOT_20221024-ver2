package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.service.TestService;
import com.example.demo.model.domain.TestDB;

@Controller
public class DemoControllerRenamed {

    @Autowired
    private TestService testService;

    @GetMapping("/testdb-renamed") // testdb 매핑 경로 수정
    public String getAllTestDBs(Model model) {
        TestDB test = testService.findByName("홍길동");
        model.addAttribute("data4", test);
        return "testdb"; // testdb.html 파일을 렌더링
    }
}
