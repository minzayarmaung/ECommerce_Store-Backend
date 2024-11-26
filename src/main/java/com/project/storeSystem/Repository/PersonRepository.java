package com.project.storeSystem.Repository;

import com.project.storeSystem.Entity.Invoice;
import com.project.storeSystem.Entity.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonData, Long> {

    @Query(value = "SELECT * FROM PDB01 WHERE 1=1 " +
            "AND (:status IS NULL OR status = :status) " +
            "AND (:id IS NULL OR T2 = :id) " +
            "AND (:name IS NULL OR T3 = :name) " +
            "AND (:branch IS NULL OR T4 = :branch) " +
            "AND (:city IS NULL OR T5 = :city) " +
            "AND (:township IS NULL OR T6 = :township) " +
            "AND (:fromDate IS NULL OR T7 >= :fromDate) " +
            "AND (:toDate IS NULL OR T8 <= :toDate) " +
            "AND (:fromTime IS NULL OR T9 >= :fromTime) " +
            "AND (:toTime IS NULL OR T10 <= :toTime)",
            nativeQuery = true)
    List<PersonData> findAdvSearchData(
            @Param("status") String status,
            @Param("id") String id,
            @Param("name") String name,
            @Param("branch") String branch,
            @Param("city") String city,
            @Param("township") String township,
            @Param("fromDate") String fromDate,
            @Param("toDate") String toDate,
            @Param("fromTime") String fromTime,
            @Param("toTime") String toTime
    );
}
