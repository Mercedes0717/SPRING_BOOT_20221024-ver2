package com.example.demo.model.service;

import com.example.demo.model.domain.Article;
import com.example.demo.model.domain.Board;
import com.example.demo.model.repository.BlogRepository;
import com.example.demo.model.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final BoardRepository boardRepository;

    // 게시판 전체 목록 조회
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    // 게시글 저장
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 게시글 단일 조회
    public Optional<Article> findById(Long id) {
        return blogRepository.findById(id);
    }

    // 게시글 수정
    public void update(Long id, AddArticleRequest request) {
        Optional<Article> optionalArticle = blogRepository.findById(id);
        optionalArticle.ifPresent(article -> {
            article.update(request.getTitle(), request.getContent());
            blogRepository.save(article);
        });
    }

    // 게시글 삭제
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    // 게시판(Board) 전체 목록 조회
    public List<Board> findAllBoards() {
        return boardRepository.findAll();
    }

    // 게시판(Board) 단일 조회
    public Optional<Board> findBoardById(Long id) {
        return boardRepository.findById(id); // BoardRepository를 사용하여 단일 게시판 글 조회
    }
}
