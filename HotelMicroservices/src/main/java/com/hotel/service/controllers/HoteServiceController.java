package com.hotel.service.controllers;

import com.hotel.service.entities.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HoteServiceController{

    @Autowired
    private HotelService hotelService;

    //Create Hotel
    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //Get ALl Hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    //Get Hotel By Id
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) throws ResourceNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }

    //Update Hotel
    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Hotel> updateHotelInfo(@RequestBody Hotel hotel, @PathVariable String hotelId) throws ResourceNotFoundException {
        Hotel updatedhotel = hotelService.getHotelById(hotelId);
        updatedhotel.setName(hotel.getName());
        updatedhotel.setLocation(hotel.getLocation());
        updatedhotel.setAbout(hotel.getAbout());
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.updateHotelInfo(updatedhotel));
    }

    //Delete Hotel
    @DeleteMapping("/delete/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId) throws ResourceNotFoundException {
        hotelService.deleteHotel(hotelService.getHotelById(hotelId));
    }
}
