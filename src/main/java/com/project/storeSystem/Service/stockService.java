package com.project.storeSystem.Service;

import com.project.storeSystem.Entity.AdvSearchData;
import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.EncryptedStock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface stockService {
    List<EncryptedStock> getAllStockItems(AdvSearchData adv);
}
