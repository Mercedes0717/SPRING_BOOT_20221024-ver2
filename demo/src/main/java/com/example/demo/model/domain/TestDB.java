package com.example.demo.model.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity // TestDB라는 객체와 DB 테이블을 매핑. JPA가 관리
@Table(name = "testdb") // 테이블 이름을 testdb로 지정
@Data // Lombok을 사용하여 getter, setter, toString 자동 생성
public class TestDB {

    @Id // 해당 변수를 PK로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 값이 없으면 자동 생성
    private Long id;

    @Column(nullable = true) // 테이블의 컬럼 설정. null 허용
    private String name;
}
