package com.project.storeSystem.Service;

import com.project.storeSystem.Entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface invoiceService {

    List<Invoice> getAllInvoiceItems();
}