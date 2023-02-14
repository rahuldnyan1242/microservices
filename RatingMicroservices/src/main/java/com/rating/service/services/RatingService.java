package com.rating.service.services;

import com.rating.service.entities.Rating;

import java.util.List;

public interface RatingService {

    //Create Ratings
    Rating createRating(Rating rating);

    //Get Al ratings
    List<Rating> getALlRating();

    //Get Rating by UserId
    List<Rating> getRatingByUserId(String userId);

    //Get Rating by HotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
