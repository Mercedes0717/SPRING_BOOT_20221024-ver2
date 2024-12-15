
        package com.example.demo.controller;
        import com.example.demo.model.domain.Article;
        import com.example.demo.model.service.BlogService;
        import lombok.RequiredArgsConstructor;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

        import java.util.Optional;

        @Controller
        @RequiredArgsConstructor
        public class BlogController {
            private final BlogService blogService;

            @GetMapping("/article_list")
            public String articleList(Model model) {
                model.addAttribute("articles", blogService.findAll());
                return "article_list";
            }

            @GetMapping("/article_edit/{id}")
            public String articleEdit(Model model, @PathVariable Long id) {
                Optional<Article> article = blogService.findById(id);
                if (article.isPresent()) {
                    model.addAttribute("article", article.get());
                    return "article_edit";
                }
                return "error_page/article_error";
            }

            @PutMapping("/api/article_edit/{id}")
            public String updateArticle(@PathVariable Long id, Article updatedArticle) {
                blogService.update(id, updatedArticle);
                return "redirect:/article_list";
            }

            @DeleteMapping("/api/article_delete/{id}")
            public String deleteArticle(@PathVariable Long id) {
                blogService.delete(id);
                return "redirect:/article_list";
            }
        }
    