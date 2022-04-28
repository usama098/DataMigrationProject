package com.sparta.datamigration.model;

public class CorruptedRecord extends EmployeeRecord {
    private String emp_id;
    private String name_prefix;
    private String firs_name;
    private String middle_initial;
    private String last_name;
    private String gender;
    private String email;
    private String date_of_birth;
    private String date_of_joining;
    private String salary;

    public String getStringEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public void setName_prefix(String name_prefix) {
        this.name_prefix = name_prefix;
    }

    public String getFirs_name() {
        return firs_name;
    }

    public void setFirs_name(String firs_name) {
        this.firs_name = firs_name;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(String date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public CorruptedRecord(String emp_id, String name_prefix, String firstName, String middle_initial, String last_name, String gender, String email, String date_of_birth, String dateOfJoin, String salary) {
        this.emp_id = emp_id;
        this.name_prefix = name_prefix;
        this.firs_name = firstName;
        this.middle_initial = middle_initial;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.date_of_joining = dateOfJoin;
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        String and = ", ";
        sb.append(emp_id);
        sb.append(and);
        sb.append(name_prefix);
        sb.append(and);
        sb.append(firs_name);
        sb.append(and);
        sb.append(middle_initial);
        sb.append(and);
        sb.append(last_name);
        sb.append(and);
        sb.append(gender);
        sb.append(and);
        sb.append(email);
        sb.append(and);
        sb.append(date_of_birth);
        sb.append(and);
        sb.append(date_of_joining);
        sb.append(and);
        sb.append(salary);
        sb.append(" ]");

        return sb.toString();
    }
}
