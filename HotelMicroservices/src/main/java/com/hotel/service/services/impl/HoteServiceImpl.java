package com.hotel.service.services.impl;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repositories.HotelRepository;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoteServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String randomHotelId = UUID.randomUUID().toString();
        hotel.setHotelId(randomHotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) throws ResourceNotFoundException{
        return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel not found for id : "+ hotelId));
    }

    @Override
    public void deleteHotel(Hotel hotel) {
            hotelRepository.delete(hotel);
    }

    @Override
    public Hotel updateHotelInfo(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
}
