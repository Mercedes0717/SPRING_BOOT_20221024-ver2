package com.example.demo.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.domain.TestDB;
import com.example.demo.model.repository.TestRepository;
import lombok.RequiredArgsConstructor;

@Service // 서비스 계층 명시, 스프링 내부 자동 등록
@RequiredArgsConstructor // 생성자 자동 생성 (Lombok)
public class TestService {

    @Autowired // 객체 주입 자동화
    private final TestRepository testRepository;

    public TestDB findByName(String name) {
        return testRepository.findByName(name);
    }
}
