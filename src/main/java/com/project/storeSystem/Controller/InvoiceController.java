package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Service.invoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:4200/")
public class InvoiceController {

    @Autowired
    private invoiceService invoiceService;

    @GetMapping("/getAllInvoiceItems")
    public List<Invoice> getAllInvoiceItems(){
        return invoiceService.getAllInvoiceItems();
    }
}
