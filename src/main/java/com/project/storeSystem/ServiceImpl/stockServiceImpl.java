package com.project.storeSystem.ServiceImpl;

import com.project.storeSystem.Entity.*;
import com.project.storeSystem.Repository.StockRepository;
import com.project.storeSystem.Service.stockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.project.storeSystem.Util.EncryptionUtil.encryptedInvoiceItems;
import static com.project.storeSystem.Util.EncryptionUtil.encryptedStockItems;

@Service
public class stockServiceImpl implements stockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<EncryptedStock> getAllStockItems(AdvSearchData adv) {
        List<Stock> items = stockRepository.findAdvSearchData(adv.getStatus() , adv.getId(), adv.getName(), adv.getBranch() , adv.getCity() ,
                adv.getTownship() , adv.getFromDate() , adv.getToDate() , adv.getFromTime() , adv.getToTime());

        List<EncryptedStock> encryptedItems = new ArrayList<>();
        items.forEach(item -> encryptedItems.add(encryptedStockItems(item)));
        return encryptedItems;
    }
}
