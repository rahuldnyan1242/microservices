package com.rating.service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @Column(name = "RatingID")
    private String ratingId;

    @Column(name = "UserID")
    private String userId;

    @Column(name = "HotelID")
    private String hotelId;

    @Column(name = "Ratings")
    private int rating;

    @Column(name = "Feedback")
    private String feedback;
}
