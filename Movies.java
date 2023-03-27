package com.project.springhibernatedatabase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Movies {
    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private int movieId;
    private String movieName;
    private String genre;
    private int rating;

}
