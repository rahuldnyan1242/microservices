package com.rating.service.repositories;

import com.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    //Customer finder method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
