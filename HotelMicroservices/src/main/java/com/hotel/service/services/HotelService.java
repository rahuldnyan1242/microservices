package com.hotel.service.services;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;

import java.util.List;

public interface HotelService {

    //Create Hotel
    Hotel create(Hotel hotel);

    //Get All Hotels
    List<Hotel> getAllHotels();

    //Get Hotel By ID
    Hotel getHotelById(String hotelId) throws ResourceNotFoundException;

    //Delete hotel
    void deleteHotel(Hotel hotel);

    //Update Hotel Info
    Hotel updateHotelInfo(Hotel hotel);
}
