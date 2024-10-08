package com.project.storeSystem.Service;

import com.project.storeSystem.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface ServiceLoginForm {

    // User Login
    public void userLogin(User user);

    // Checking Valid License
    boolean checkValidLicense(User user);

    // Checking Valid User or Not
    boolean checkValidUser(User user);
}
