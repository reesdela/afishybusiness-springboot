package com.fishybusiness.afishybusiness.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fishybusiness.afishybusiness.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
