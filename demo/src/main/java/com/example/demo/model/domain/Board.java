package com.example.demo.model.domain;

import lombok.*;
import jakarta.persistence.*;

@Getter
@Entity
@Table(name = "board") // 매핑될 테이블 이름
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 자동 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title = "";

    @Column(name = "content", nullable = false)
    private String content = "";

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 현재 객체 상태 업데이트 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
