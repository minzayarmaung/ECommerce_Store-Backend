package com.project.storeSystem.Service;

import com.project.storeSystem.Entity.AdvSearchData;
import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.EncryptedPersonData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface personService {

    List<EncryptedPersonData> getAllPersonData(AdvSearchData adv);
}
