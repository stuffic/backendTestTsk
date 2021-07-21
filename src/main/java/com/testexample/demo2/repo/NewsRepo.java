package com.testexample.demo2.repo;

import  com.testexample.demo2.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {
}
