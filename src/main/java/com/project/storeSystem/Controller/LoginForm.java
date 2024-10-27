package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.User;
import com.project.storeSystem.Service.ServiceLoginForm;
import com.project.storeSystem.Util.TokenUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200/")
public class LoginForm {

    @Autowired
    private ServiceLoginForm serviceLoginForm;

    @PostMapping("/signin")
    public ResponseEntity<Map<String , String>> signin (@RequestBody User user ,
                                          @RequestHeader(value = "Authorization" , required = false) String token) {

        Map<String , String> response = new HashMap<>();

        System.out.println(user);
        boolean isValidLicense = false;
        boolean isValidUser = false;
        isValidLicense = serviceLoginForm.checkValidLicense(user);
        isValidUser = serviceLoginForm.checkValidUser(user);

        if (token != null && TokenUtil.validToken(token, user.getUsername())) {
            return ResponseEntity.ok(response);
        }

        if (isValidLicense && isValidUser) {
            String jwtToken = TokenUtil.generateToken(user.getUsername());
            response.put("message", "Login Successfully.");
            response.put("token", jwtToken);
            return ResponseEntity.ok(response);
        } else if (isValidLicense && !isValidUser) {
            response.put("message", "User Not Found");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        } else {
            response.put("message", "Invalid License");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }
    }
}
