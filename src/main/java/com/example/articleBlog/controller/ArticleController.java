package com.example.articleBlog.controller;

import com.example.articleBlog.model.Article;
import com.example.articleBlog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
    }

    @GetMapping("/search")
    public Page<Article> searchArticles(@RequestParam String title,
                                        @RequestParam int page,
                                        @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return articleService.searchArticles(title, pageable);
    }

}