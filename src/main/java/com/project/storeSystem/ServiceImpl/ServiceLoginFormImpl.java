package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.User;
import com.project.storeSystem.Repository.UserRepository;
import com.project.storeSystem.Service.ServiceLoginForm;
import com.project.storeSystem.Util.ServerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLoginFormImpl implements ServiceLoginForm{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void userLogin(User user) {
        String sql = "SELECT T1 and T2 FROM U001 where RecordStatus <> 4";


    }
    @Override
    public boolean checkValidLicense(User user) {
        String today = ServerUtil.getLocalDate();
        Optional<String> validLicense = userRepository.checkValidLicense();
        if (validLicense.isPresent()) {
            String validLic = validLicense.get();
            LocalDate licenseDate = LocalDate.parse(validLic);
            LocalDate currentDate = LocalDate.parse(today);

            return currentDate.isBefore(licenseDate);
        } else {
            return false;  // No valid license found
        }
    }

    @Override
    public boolean checkValidUser(User user) {


        return true;
    }
}
