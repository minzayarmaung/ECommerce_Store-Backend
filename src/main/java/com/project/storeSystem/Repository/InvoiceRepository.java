package com.project.storeSystem.Repository;

import com.project.storeSystem.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice , Long> {

    @Query(value = "SELECT * FROM INV001 WHERE STATUS <> ?" , nativeQuery = true)
    List<Invoice> getDatabyStatus(String status);

    @Query(value = "SELECT * FROM INV001 WHERE STATUS <> ? AND ID = ? AND " , nativeQuery = true)
    List<Invoice> getAdvSearchData(String status , String id , String name , String branch ,
                                   String city , String township , String fromDate ,
                                   String toDate , String fromTime, String toTime);

}
