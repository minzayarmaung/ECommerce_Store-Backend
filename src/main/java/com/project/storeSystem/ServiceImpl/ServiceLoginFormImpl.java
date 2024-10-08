package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.User;
import com.project.storeSystem.Service.ServiceLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLoginFormImpl implements ServiceLoginForm{

    @Autowired
    private ServiceLoginForm serviceLoginForm;

    @Override
    public void userLogin(User user) {
        String sql = "SELECT T1 and T2 FROM U001 where RecordStatus <> 4";


    }
}
