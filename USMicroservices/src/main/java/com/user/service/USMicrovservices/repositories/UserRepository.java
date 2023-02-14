package com.user.service.USMicrovservices.repositories;

import com.user.service.USMicrovservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
