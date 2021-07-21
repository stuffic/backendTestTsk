package com.testexample.demo2.service;

import com.testexample.demo2.model.News;
import com.testexample.demo2.repo.NewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NewsService {

    private NewsRepo newsRepo;

    @Autowired
    public NewsService(NewsRepo newsRepo){
        this.newsRepo = newsRepo;
    }

    public List<News> findAll(){
        return StreamSupport.stream(newsRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<News> findById(Long id){
        return newsRepo.findById(id);
    }

    public News save(News stock) {
        return newsRepo.save(stock);
    }

    public void deleteById(Long id){
        newsRepo.deleteById(id);
    }
}
