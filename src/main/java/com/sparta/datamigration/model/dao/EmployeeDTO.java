package com.sparta.datamigration.model.dao;

import java.sql.Date;

//                   Data Transfer Object
public class EmployeeDTO {
    private int emp_id;
    private String name_prefix;
    private String first_name;
    private String middle_initial;
    private String last_name;
    private boolean gender;     // Male = 0, female = 1
    private String email;
    private Date date_of_birth;
    private Date date_of_joining;
    private int salary;

    // should move all the .convertData() functions from validate folders here
    //  worth to keep EmployeeRecord all String, so could pass on String[] to constructor
    //  worth movin all .validateData into Validate class as just by the field name, so it can be called by:
    //              Validate.employeeID();
}
