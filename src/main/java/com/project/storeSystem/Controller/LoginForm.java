package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginForm {

    @PostMapping("signin")
    public ResponseEntity<String> userSignin (User user){


        return ResponseEntity.ok("Sign In Successfully !");
    }

}
