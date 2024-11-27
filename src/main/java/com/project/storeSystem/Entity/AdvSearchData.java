package com.project.storeSystem.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvSearchData {

    private String id;
    private String name;
    private String fromDate;
    private String toDate;
    private String fromTime;
    private String toTime;
    private String status;
    private String branch;
    private String city;
    private String township;
    private String gender;
    private String maritalStatus;
    private String religion;
    private String phoneNumber;
    private String email;
    private String jobPosition;

}
