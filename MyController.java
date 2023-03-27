package com.project.springhibernatedatabase.controller;
import com.project.springhibernatedatabase.entity.Movies;
import com.project.springhibernatedatabase.service.ServiceList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MyController {
    private ServiceList serviceList;
    public MyController(ServiceList serviceList){
        this.serviceList=serviceList;
    }
    @GetMapping
    public List<Movies> getAll(){
        return serviceList.getAll();
    }
    @GetMapping("{movieId}")
    public ResponseEntity<Movies> get(@PathVariable("id") int movieId){
        return new ResponseEntity<Movies>(serviceList.get(movieId), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<Movies> post(@RequestBody Movies movie){
        return new ResponseEntity<Movies>(serviceList.post(movie), HttpStatus.CREATED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int movieId){
        serviceList.delete(movieId);
        return new ResponseEntity<String>("Movie Removed From Database", HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Movies> update(@PathVariable("id") int movieId,@RequestBody Movies movie ){
        return new ResponseEntity<Movies>(serviceList.update(movieId,movie), HttpStatus.OK);
    }
}
