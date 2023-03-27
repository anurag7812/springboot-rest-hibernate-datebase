package com.project.springhibernatedatabase.service;

import com.project.springhibernatedatabase.entity.Movies;

import java.util.List;

public interface ServiceList {
    //list down all functionalities
    //list all movies
    //->return movie's object
    public Movies post(Movies movie);
    public List<Movies> getAll();
    public Movies get(int movieId);
//    public Movies update(Movies movie,int movieId);
    public Movies delete(int movieId);
    public Movies update (int movieId,Movies movie);


}
