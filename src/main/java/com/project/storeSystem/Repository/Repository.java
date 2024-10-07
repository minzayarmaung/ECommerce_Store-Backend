package com.project.storeSystem.Repository;

import com.project.storeSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);
}
