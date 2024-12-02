package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.AdvSearchData;
import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Entity.EncryptedStock;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.storeSystem.Service.stockService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:4200/")
public class StockController {

    @Autowired
    private stockService stockService;

    @PostMapping("/getAllStockItems")
    public List<EncryptedStock> getAllStockItems(@RequestBody AdvSearchData adv){
        return stockService.getAllStockItems(adv);
    }
}
