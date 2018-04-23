package com.ebookstore.restservice.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;

import java.util.List;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name = "volumes")
@NoArgsConstructor
//component below leads parse error of http
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Volume {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)//For Long
    private Long id;
    private String title;
    private String subtitle;
    //@ManyToMany
    private String authors;
    //@ManyToMany
    private String categories;
    private String publisher;
    private String publishedDate;
    private String description;
    private String isbn;
    private Integer pageCount;
    private String language;
    private Float ratingCount;
    //@OneToMany
    private String imageLinks;

    public Volume(String title, String subtitle,
                  String authors, String categories,
                  String publisher, String publishedDate,
                  String description, String isbn,
                  Integer pageCount, String language,
                  Float ratingCount, String imageLinks){

        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.categories = categories;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.isbn = isbn;
        this.pageCount = pageCount;
        this.language = language;
        this.ratingCount = ratingCount;
        this.imageLinks = imageLinks;
    }

}

