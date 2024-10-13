package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.User;
import com.project.storeSystem.Service.ServiceLoginForm;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginForm {

    @Autowired
    private ServiceLoginForm serviceLoginForm;

    @PostMapping("/signin")
    public ResponseEntity<String> signin (@RequestBody User user){
        System.out.println(user);
        boolean isValidLicense = false;
        boolean isValidUser = false;
        isValidLicense = serviceLoginForm.checkValidLicense(user);
        isValidUser = serviceLoginForm.checkValidUser(user);

        if (isValidLicense && isValidUser){
            return ResponseEntity.status(HttpStatus.CREATED).body("Login Successfully");
        }
        else if (isValidLicense && !isValidUser){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid License");
        }
    }

}
