package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Service.invoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:4200/")
public class InvoiceController {

    @Autowired
    private invoiceService invoiceService;

    @PostMapping("/getAllInvoiceItems")
    public List<EncryptedInvoice> getAllInvoiceItems(){
        return invoiceService.getAllInvoiceItems();
    }
}
