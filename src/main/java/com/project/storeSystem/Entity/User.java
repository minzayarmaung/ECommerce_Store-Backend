package com.project.storeSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "U001" , schema = "dbo")
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String createddate;
    private String modifieddate;
    private String T1;
    private String T2;
    private String T3;
    private String T4;
    private String T5;
    private String T6;
    private String T7;
    private String T8;
    private String T9;
    private String T10;
    private long N1;
    private long N2;
    private long N3;
    private long N4;
    private long N5;
    private long status;



}
