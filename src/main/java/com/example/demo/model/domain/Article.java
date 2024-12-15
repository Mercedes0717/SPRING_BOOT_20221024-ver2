
        package com.example.demo.model.domain;
        import jakarta.persistence.*;
        import lombok.*;

        @Entity
        @Table(name = "article")
        @Getter
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public class Article {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @Column(nullable = false)
            private String title;

            @Column(nullable = false)
            private String content;

            @Builder
            public Article(String title, String content) {
                this.title = title;
                this.content = content;
            }

            public void update(String title, String content) {
                this.title = title;
                this.content = content;
            }
        }
    