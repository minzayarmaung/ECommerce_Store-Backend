package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Repository.InvoiceRepository;
import com.project.storeSystem.Service.invoiceService;
import com.project.storeSystem.Util.AESAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class invoiceServiceImpl implements invoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override
    public List<Invoice> getAllInvoiceItems() {
        List<Invoice> items = invoiceRepository.findAll();
        items.forEach(this::encryptedInvoiceItems);
        return items;
    }

    private void encryptedInvoiceItems(Invoice invoice) {
        try{
//            invoice.setSyskey(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getSyskey()))));
//            invoice.setAutokey(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getAutokey()))));

            // String
            invoice.setCreatedDate(AESAlgorithm.encryptString(invoice.getCreatedDate()));
            invoice.setModifiedDate(AESAlgorithm.encryptString(invoice.getModifiedDate()));
            invoice.setT1(AESAlgorithm.encryptString(invoice.getT1()));
            invoice.setT2(AESAlgorithm.encryptString(invoice.getT2()));
            invoice.setT3(AESAlgorithm.encryptString(invoice.getT3()));
            invoice.setT4(AESAlgorithm.encryptString(invoice.getT4()));
            invoice.setT5(AESAlgorithm.encryptString(invoice.getT5()));
            invoice.setT6(AESAlgorithm.encryptString(invoice.getT6()));
            invoice.setT7(AESAlgorithm.encryptString(invoice.getT7()));
            invoice.setT8(AESAlgorithm.encryptString(invoice.getT8()));
            invoice.setT9(AESAlgorithm.encryptString(invoice.getT9()));
            invoice.setT10(AESAlgorithm.encryptString(invoice.getT10()));
            invoice.setT11(AESAlgorithm.encryptString(invoice.getT11()));
            invoice.setT12(AESAlgorithm.encryptString(invoice.getT12()));
            invoice.setT13(AESAlgorithm.encryptString(invoice.getT13()));
            invoice.setT14(AESAlgorithm.encryptString(invoice.getT14()));
            invoice.setT15(AESAlgorithm.encryptString(invoice.getT15()));

            // Long
//            invoice.setN1(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN1()))));
//            invoice.setN2(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN2()))));
//            invoice.setN3(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN3()))));
//            invoice.setN4(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN4()))));
//            invoice.setN5(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN5()))));
//            invoice.setN6(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN6()))));
//            invoice.setN7(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN7()))));
//            invoice.setN8(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN8()))));
//            invoice.setN9(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN9()))));
//            invoice.setN10(Long.parseLong(AESAlgorithm.encryptString(String.valueOf(invoice.getN10()))));

        } catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error Encrypting Invoice Items");
        }
    }
}
