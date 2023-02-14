package com.user.service.USMicrovservices.impl;

import com.user.service.USMicrovservices.entities.Hotel;
import com.user.service.USMicrovservices.entities.Rating;
import com.user.service.USMicrovservices.entities.User;
import com.user.service.USMicrovservices.exceptions.ResourceNotFoundException;
import com.user.service.USMicrovservices.external.services.HotelService;
import com.user.service.USMicrovservices.repositories.UserRepository;
import com.user.service.USMicrovservices.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomuserID = UUID.randomUUID().toString();
        user.setUserId(randomuserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for ID: "+ userId));
        //Get rating from RATING-SERVICE
        //http://localhost:8083/ratings/users/742b2e26-9604-4625-97eb-48e63c7ff03d
        Rating[] ratingsOfUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+userId, Rating[].class);
        logger.info("User Info :{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //Get Hotels list from rating
//           Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
           //Set Hotel to rating list
            logger.info("Hotel info: {}", hotel);
           rating.setHotel(hotel);
           return rating;

        }).collect(Collectors.toList());


        user.setRatings(ratingList);
        return user;
    }

    @Override
    public void deleteUserByID(String userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for ID: "+ userId));
        userRepository.delete(user);
    }

    @Override
    public User updateUser(User user, String userId) throws ResourceNotFoundException {
        User updateUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found for ID: "+ userId));
        updateUser.setAbout(user.getAbout());
        updateUser.setName(user.getName());
        updateUser.setEmail(updateUser.getEmail());

        return userRepository.save(updateUser);
    }
}
