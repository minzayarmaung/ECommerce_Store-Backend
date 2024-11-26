package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.AdvSearchData;
import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Repository.InvoiceRepository;
import com.project.storeSystem.Service.invoiceService;
import com.project.storeSystem.Util.AESAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.storeSystem.Util.EncryptionUtil.encryptedInvoiceItems;

@Service
public class invoiceServiceImpl implements invoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override
    public List<EncryptedInvoice> getAllInvoiceItems(AdvSearchData adv) {

        List<Invoice> items = invoiceRepository.findAdvSearchData(adv.getStatus() , adv.getId(), adv.getName(), adv.getBranch() , adv.getCity() ,
                adv.getTownship() , adv.getFromDate() , adv.getToDate() , adv.getFromTime() , adv.getToTime());

        List<EncryptedInvoice> encryptedItems = new ArrayList<>();
        items.forEach(item -> encryptedItems.add(encryptedInvoiceItems(item)));
        return encryptedItems;
    }


}
