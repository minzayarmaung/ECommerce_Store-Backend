package com.project.storeSystem.Repository;

import com.project.storeSystem.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice , Long> {

//    @Query("SELECT * FROM INV001 WHERE status <> 4")
//    List<Invoice> getAllInvoiceItems();
}
