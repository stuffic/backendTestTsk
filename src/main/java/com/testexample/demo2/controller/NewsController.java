package com.testexample.demo2.controller;

import com.testexample.demo2.model.News;
import com.testexample.demo2.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/*import com.testexample.demo2.service.NewsService;*/
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import javax.validation.Valid;

@CrossOrigin("*")
@RestController
public class NewsController {

    @Autowired
    private NewsRepo newsRepo;


    @CrossOrigin
    @GetMapping("/news")
        public List <News> getAllNews(){
            return newsRepo.findAll();
    }

    @CrossOrigin
    @GetMapping("/news/{id}")
    public ResponseEntity <News> getNewsById(@PathVariable(value = "id") Long id) {
        News news = newsRepo.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("Invalid news Id:" + id);
                });
        return ResponseEntity.ok().body(news);
    }

    @PostMapping("/news")
    public News createNews(@Valid @RequestBody News news) {
        return newsRepo.save(news);
    }

    @DeleteMapping("/news/{id}")
    public List <News> deleteNews(@PathVariable Long id, Model model) {
        newsRepo.findById(id)
                .orElseThrow(() -> {return new IllegalArgumentException("Invalid news Id:" + id);});
        newsRepo.deleteById(id);
        return newsRepo.findAll();
    }

    @PutMapping("/news/{id}")
    public ResponseEntity <News> updateNews(@PathVariable(value = "id") Long id, @Valid @RequestBody News newNews) {
        News news = newsRepo.findById(id)
                .orElseThrow(() -> {return new IllegalArgumentException("Invalid news Id:" + id);});
        news.setAuthor(newNews.getAuthor());
        news.setHeadline(newNews.getHeadline());
        news.setDescription(newNews.getDescription());
        final News updatedNews = newsRepo.save(news);
        return ResponseEntity.ok(updatedNews);
    }

    @GetMapping("/instructors/{username}/news")
    public List<News> getAllCNews(@PathVariable String username) {
        return newsRepo.findAll();
    }

}
