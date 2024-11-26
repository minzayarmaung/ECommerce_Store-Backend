package com.project.storeSystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PDB01" , schema = "dbo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long syskey;

    private long autokey;

    private String createdDate;
    private String modifiedDate;
    private long status;
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
    private String T11;
    private String T12;
    private String T13;
    private String T14;
    private String T15;
    private long N1;
    private long N2;
    private long N3;
    private long N4;
    private long N5;
    private long N6;
    private long N7;
    private long N8;
    private long N9;
    private long N10;
}
