package com.rcoem.deveops;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student {

    private String studentId;
    private String name;
    private String email;
    private String address;
    private String phone;
    private String password; // Add this field to store the student's password

}
