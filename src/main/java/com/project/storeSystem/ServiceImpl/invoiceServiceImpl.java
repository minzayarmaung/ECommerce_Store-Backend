package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Repository.InvoiceRepository;
import com.project.storeSystem.Service.invoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class invoiceServiceImpl implements invoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override
    public List<Invoice> getAllInvoiceItems() {
        return invoiceRepository.findAll();
    }
}
