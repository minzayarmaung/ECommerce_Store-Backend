package com.project.storeSystem.Controller;

import com.project.storeSystem.Entity.AdvSearchData;
import com.project.storeSystem.Entity.EncryptedInvoice;
import com.project.storeSystem.Service.invoiceService;
import com.project.storeSystem.Util.SystemUtil;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "http://localhost:4200/")
public class InvoiceController {

    ServletContext context;

    HttpServletResponse response;
    HttpServletRequest request;

    @Autowired
    private invoiceService invoiceService;

    @PostMapping("/getAllInvoiceItems")
    public List<EncryptedInvoice> getAllInvoiceItems(@RequestBody AdvSearchData adv){
        return invoiceService.getAllInvoiceItems(adv);
    }

    @PostMapping("/downloadFile")
    public String downloadFile(String fileName){
        String folder = context.getRealPath("/") + "/resources/templates/";
        SystemUtil.downloadFile(folder , fileName , request , response);
        return "";
    }
}
