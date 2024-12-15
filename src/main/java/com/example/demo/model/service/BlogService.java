
        package com.example.demo.model.service;
        import com.example.demo.model.domain.Article;
        import com.example.demo.model.repository.BlogRepository;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

        @Service
        @RequiredArgsConstructor
        public class BlogService {
            private final BlogRepository blogRepository;

            public List<Article> findAll() {
                return blogRepository.findAll();
            }

            public Optional<Article> findById(Long id) {
                return blogRepository.findById(id);
            }

            public Article save(Article article) {
                return blogRepository.save(article);
            }

            public void update(Long id, Article updatedArticle) {
                blogRepository.findById(id).ifPresent(article -> {
                    article.update(updatedArticle.getTitle(), updatedArticle.getContent());
                    blogRepository.save(article);
                });
            }

            public void delete(Long id) {
                blogRepository.deleteById(id);
            }
        }
    