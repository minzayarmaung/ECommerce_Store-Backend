package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Entity.User;
import com.project.storeSystem.Repository.InvoiceRepository;
import com.project.storeSystem.Repository.UserRepository;
import com.project.storeSystem.Service.ServiceLoginForm;
import com.project.storeSystem.Util.AESAlgorithm;
import com.project.storeSystem.Util.ServerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLoginFormImpl implements ServiceLoginForm{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void userLogin(User user) {

    }
    @Override
    public boolean checkValidLicense(User user) {
        String today = ServerUtil.getLocalDate();
        Optional<String> validLicense = userRepository.checkValidLicense();
        if (validLicense.isPresent()) {
            String validLic = validLicense.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate licenseDate = LocalDate.parse(validLic , formatter);

            DateTimeFormatter todayFormatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
            LocalDate currentDate = LocalDate.parse(today , todayFormatter);

            return currentDate.isBefore(licenseDate);
        } else {
            return false;
        }
    }

    @Override
    public boolean checkValidUser(User user) {
        Optional<Object[]> result = userRepository.checkValidUser();
        if (result.isPresent()) {
            Object[] data = (Object[]) result.get()[0];

            String dbUsername = (String) data[0];
            String dbPassword = (String) data[1];

            if (user.getUsername().equalsIgnoreCase(dbUsername) && user.getT3().equals(dbPassword)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
