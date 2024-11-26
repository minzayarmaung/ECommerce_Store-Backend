package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.*;
import com.project.storeSystem.Repository.PersonRepository;
import com.project.storeSystem.Service.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project.storeSystem.Util.EncryptionUtil.encryptedPersonData;

import java.util.ArrayList;
import java.util.List;

@Service
public class personServiceImpl implements personService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<EncryptedPersonData> getAllPersonData(AdvSearchData adv) {
        List<PersonData> items = personRepository.findAdvSearchData(adv.getStatus() , adv.getId(), adv.getName(), adv.getBranch() , adv.getCity() ,
                adv.getTownship() , adv.getFromDate() , adv.getToDate() , adv.getFromTime() , adv.getToTime());

        List<EncryptedPersonData> encryptedData = new ArrayList<>();
        items.forEach(data -> encryptedData.add(encryptedPersonData(data)));
        return encryptedData;
    }
}
