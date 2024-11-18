package com.project.storeSystem.Entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonPropertyOrder({
        "encryptedSyskey",
        "encryptedAutokey",
        "createdDate",
        "modifiedDate",
        "status",
        "t1", "t2", "t3", "t4", "t5",
        "t6", "t7", "t8", "t9", "t10",
        "t11", "t12", "t13", "t14", "t15",
        "n1", "n2", "n3", "n4", "n5",
        "n6", "n7", "n8", "n9", "n10"
})

public class EncryptedInvoice {

    private String encryptedSyskey;
    private String encryptedAutokey;

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
    private String N1;
    private String N2;
    private String N3;
    private String N4;
    private String N5;
    private String N6;
    private String N7;
    private String N8;
    private String N9;
    private String N10;
}
