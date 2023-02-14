package com.user.service.USMicrovservices.services;

import com.user.service.USMicrovservices.entities.User;
import com.user.service.USMicrovservices.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService {

    //create User
    User saveUser(User user);

    //Get All users
    List<User> getALlUsers();

    //Get User By id
    User getUserById(String userId) throws ResourceNotFoundException;

    //Delete User
    void deleteUserByID(String userId) throws ResourceNotFoundException;

    //Update User
    User updateUser(User user, String userId) throws ResourceNotFoundException;


}
