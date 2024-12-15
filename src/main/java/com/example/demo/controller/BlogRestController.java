
        package com.example.demo.controller;

        import com.example.demo.model.domain.Article;
        import com.example.demo.model.service.BlogService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        @RestController
        @RequiredArgsConstructor
        public class BlogRestController {
            private final BlogService blogService;

            // Save article via REST API
            @PostMapping("/api/articles")
            public ResponseEntity<Article> addArticle(@RequestBody Article article) {
                Article savedArticle = blogService.save(article);
                return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
            }

            // Handle favicon.ico requests to prevent errors
            @GetMapping("/favicon.ico")
            public void favicon() {
                // No action required
            }
        }
    