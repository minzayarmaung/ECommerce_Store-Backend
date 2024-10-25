package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.User;
import com.project.storeSystem.Service.ServiceLoginForm;
import com.project.storeSystem.Util.TokenUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginForm {

    @Autowired
    private ServiceLoginForm serviceLoginForm;

    @PostMapping("/signin")
    public ResponseEntity<String> signin (@RequestBody User user ,
                                          @RequestHeader(value = "Authorization" , required = false) String token) {
        System.out.println(user);
        boolean isValidLicense = false;
        boolean isValidUser = false;
        isValidLicense = serviceLoginForm.checkValidLicense(user);
        isValidUser = serviceLoginForm.checkValidUser(user);

        if (token != null && TokenUtil.validToken(token, user.getUsername())) {
            return ResponseEntity.status(HttpStatus.OK).body("Already signed in with a valid token.");
        }

        if (isValidLicense && isValidUser) {
            String jwtToken = TokenUtil.generateToken(user.getUsername());
            return ResponseEntity.status(HttpStatus.OK).body("Login Successfully.");
        } else if (isValidLicense && !isValidUser) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User Not Found");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid License");
        }
    }
}
