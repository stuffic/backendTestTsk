package com.testexample.demo2.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    private String author;

    @Column
    private String description;

    public News(){

    }

    public News(String headline, String author, String description){
        this.headline = headline;
        this.author = author;
        this.description = description;
    }

    public Long getId(){
        return id;
    }

    public String getHeadline(){
        return headline;
    }

    public void setHeadline(String headline){
        this.headline = headline;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getDescription(){
        return  description;
    }

    public void setDescription(String description){
        this.description = description;

    }

}
