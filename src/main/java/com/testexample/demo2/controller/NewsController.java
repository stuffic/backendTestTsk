package com.testexample.demo2.controller;

import com.testexample.demo2.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.testexample.demo2.service.NewsService;


import java.util.List;

@Controller
public class NewsController {

    private  NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @GetMapping("/news")
    public String findAll(Model model){
        List<News> news = service.findAll();
        model.addAttribute("news", news);
        return "news-list";
    }

    @GetMapping("/news/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        News news = service.findById(id)
            .orElseThrow(() ->  {return new IllegalArgumentException("Invalid news Id:" + id);});
        model.addAttribute("news", news);
        return "news-list";
    }

    @GetMapping("/edit-news/{id}")
    public String editNewsForm(@PathVariable("id") Long id, Model model){
        News news = service.findById(id)
            .orElseThrow(() -> {return new IllegalArgumentException("Invalid news Id:" + id);});
        model.addAttribute("news", news);
        return "edit-news";
    }

    @PostMapping("/edit-news")
    public String editNews(News news){
        service.save(news);
        return "redirect:/news";
    }

    @PostMapping ("/{id}/delete")
    public String deleteNews(@PathVariable Long id, Model model) {
        service.findById(id)
                .orElseThrow(() -> {return new IllegalArgumentException("Invalid news Id:" + id);});
        service.deleteById(id);
        model.addAttribute("news", service.findAll());
        return "redirect:/news";
    }

    @GetMapping("/news-create")
    public String createNewsForm(News news){
        return "new-news";
    }

    @PostMapping("/news-create")
    public String createNews(News news){
        service.save(news);
        return "redirect:/news";
    }
}
