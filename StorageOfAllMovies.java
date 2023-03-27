package com.project.springhibernatedatabase.repository;

import com.project.springhibernatedatabase.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageOfAllMovies extends JpaRepository<Movies, Integer> {

}
