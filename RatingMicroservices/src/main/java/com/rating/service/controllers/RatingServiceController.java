package com.rating.service.controllers;

import com.rating.service.entities.Rating;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingServiceController {

    @Autowired
    private RatingService ratingService;

    //Create Ratings
    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    //GetALl Ratings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating(){
        return ResponseEntity.ok(ratingService.getALlRating());
    }

    //Get rating by User ID;
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //Get rating by Hotel ID
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }
}
