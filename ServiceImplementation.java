package com.project.springhibernatedatabase.service;

import com.project.springhibernatedatabase.entity.Movies;
import com.project.springhibernatedatabase.exceptionhandling.HandleException;
import com.project.springhibernatedatabase.repository.StorageOfAllMovies;
import org.objectweb.asm.Handle;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceImplementation implements  ServiceList {
    //I can only access Movies Entity using MyRepository
    // so to access the movies entity I need  object of myRepository
    // here I need to add data in rest and then it will be added to mysql
    // so to achieve this JpaRepository help us to do so .

    private StorageOfAllMovies storage;

    // I need this repo object because JpaRepository provides a lot of inbuilt methods
    //And we don't have to worry about rest-mysql connection
    public ServiceImplementation(StorageOfAllMovies storage) {
        this.storage = storage;
    }

    @Override
    public List<Movies> getAll() {
        return storage.findAll();
    }

    @Override
    public Movies get(int movieId) {
        return storage.findById(movieId).orElseThrow(() -> new HandleException());
    }

    @Override
    public Movies post(Movies movie) {
        return storage.save(movie);
    }

    @Override
    public Movies delete(int movieId) {
        storage.deleteById(movieId);
        return null;
    }
    @Override
    public Movies update(int movieId,Movies movie){
        Movies movie1=storage.findById(movieId).orElseThrow(()-> new HandleException());
        movie1.setMovieName(movie.getMovieName());
        movie1.setMovieId(movie.getMovieId());
        movie1.setGenre(movie.getGenre());
        movie1.setRating(movie.getRating());
        storage.save(movie1);
        //set all value to movie1
        return movie1;
    }
}
