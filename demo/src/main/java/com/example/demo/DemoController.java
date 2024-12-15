package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.domain.TestDB;
import com.example.demo.model.service.TestService;

@Controller // 컨트롤러 어노테이션 명시
public class DemoController {

    @Autowired
    private TestService testService; // 서비스 클래스 연동

    @GetMapping("/hello") // 전송 방식 GET
    public String hello(Model model) {
        model.addAttribute("data", "방갑습니다."); // model 설정
        return "hello"; // hello.html 연결
    }

    @GetMapping("/about_detailed") // 상세 페이지 매핑 추가
    public String about() {
        return "about_detailed"; // about_detailed.html 연결
    }

    @GetMapping("/test1") // test1 매핑 추가
    public String thymeleaf_test1(Model model) {
        model.addAttribute("data1", "<h2> 방갑습니다 </h2>");
        model.addAttribute("data2", "태그의 속성 값");
        model.addAttribute("link", "01");
        model.addAttribute("name", "홍길동");
        model.addAttribute("para1", "001");
        model.addAttribute("para2", "002");
        return "thymeleaf_test1"; // thymeleaf_test1.html 연결
    }

    @GetMapping("/testdb-demo") // testdb 매핑 경로 수정
    public String getAllTestDBs(Model model) {
        TestDB test = testService.findByName("홍길동"); // TestService의 findByName 메서드 호출
        model.addAttribute("data4", test);
        System.out.println("데이터 출력 디버그 : " + test);
        return "testdb"; // testdb.html 연결
    }

    @Override
    public String toString() {
        return "DemoController []";
    }
}
