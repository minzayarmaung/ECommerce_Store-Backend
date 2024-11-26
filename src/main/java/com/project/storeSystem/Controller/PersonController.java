package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.AdvSearchData;
import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.EncryptedPersonData;
import com.project.storeSystem.Service.personService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonController {

    @Autowired
    private personService personService;

    @PostMapping("/getAllPersonData")
    public List<EncryptedPersonData> getAllInvoiceItems(@RequestBody AdvSearchData adv){
        return personService.getAllPersonData(adv);
    }
}
