
        package com.example.demo.model.domain;
        import jakarta.persistence.*;
        import lombok.*;

        @Entity
        @Table(name = "board")
        @Getter
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public class Board {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;

            @Column(nullable = false)
            private String title;

            @Column(nullable = false)
            private String content;

            @Column(nullable = false)
            private String user;

            @Column(nullable = false)
            private String newdate;

            @Column(nullable = false)
            private int count;

            @Column(nullable = false)
            private int likec;

            @Builder
            public Board(String title, String content, String user, String newdate, int count, int likec) {
                this.title = title;
                this.content = content;
                this.user = user;
                this.newdate = newdate;
                this.count = count;
                this.likec = likec;
            }

            public void update(String title, String content, String user, String newdate, int count, int likec) {
                this.title = title;
                this.content = content;
                this.user = user;
                this.newdate = newdate;
                this.count = count;
                this.likec = likec;
            }
        }
    