package com.sparta.datamigration.model;

import com.sparta.datamigration.util.LoggingClass;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

//                   Data Transfer Object
public class EmployeeDTO extends EmployeeRecord implements Comparable{

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

    public EmployeeDTO(String[] data) {
        /*
            ID      0   173003
            Pref    1   Mrs.
            FName   2   Willia
            MInit   3   Q
            LName   4   Weigand
            Gender  5   F
            Email   6   willia.weigand@gmail.com
            Birth   7   10/20/1960
            Join    8   7/30/2005
            Salary  9   158292
        */
        this.emp_id = convertInteger(data[0]);
        this.name_prefix = data[1];
        this.first_name = data[2];
        this.middle_initial = data[3];
        this.last_name = data[4];
        this.gender = convertGender(data[5]);
        this.email = data[6];
        this.date_of_birth = convertDate(data[7]);
        this.date_of_joining = convertDate(data[8]);
        this.salary = convertInteger(data[9]);
    }

    private static int convertInteger(String stringToParse) {
        int number;
        try {
            number = Integer.parseInt(stringToParse);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Integer could not be converted @EmployeeDTA construction. Used default 0 value.");
            number = 0;
        }
        return number;
    }

    private static boolean convertGender(String gender) {
        if (gender.equals("M")) {
            LoggingClass.traceLog("Gender = Male");
            return false;
        } else {
            LoggingClass.traceLog("Gender = Female");
            return true;
        }
    }

    private static Date convertDate(String stringToParse) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = new java.util.Date();

        try {
            date = df.parse(stringToParse);
            date = new Date(date.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
            LoggingClass.traceLog("Date could not be converted @EmployeeDTA construction. Used default 1900-01-01 value.");
            date = new Date(1900, 1, 1);
        }

        return (Date)date;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getStringEmp_id(){
        StringBuilder id = new StringBuilder(Integer.toString(this.emp_id));

        while (id.length() < 6) {
            id.insert(0, 0);
        }

        return id.toString();
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_initial() {
        return middle_initial;
    }

    public void setMiddle_initial(String middle_initial) {
        this.middle_initial = middle_initial;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Date getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(Date date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Object o) {
        String compareEmpID = ((EmployeeDTO)o).getStringEmp_id();

        return this.getStringEmp_id().compareTo(compareEmpID);
    }

    public static Comparator<EmployeeDTO> idComparator = new Comparator<>() {
        @Override
        public int compare(EmployeeDTO record1, EmployeeDTO record2) {
            return record1.compareTo(record2);
        }
    };

    // should move all the .convertData() functions from validate folders here
    //  worth to keep EmployeeRecord all String, so could pass on String[] to constructor
    //  worth movin all .validateData into Validate class as just by the field name, so it can be called by:
    //              Validate.employeeID();



}
