package com.project.storeSystem.Repository;

import com.project.storeSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<User , Long> {
    Optional<User> findByUsername(String username);

    @Query("SELECT u.T2 FROM User u WHERE u.status = 1")
    Optional<String> checkValidLicense();

}
