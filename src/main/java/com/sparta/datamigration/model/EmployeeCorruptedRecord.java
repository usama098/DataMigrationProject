package com.sparta.datamigration.model;

public class EmployeeCorruptedRecord extends Employee {
    private String emp_id;
    private String name_prefix;
    private String first_name;
    private String middle_initial;
    private String last_name;
    private String gender;
    private String email;
    private String date_of_birth;
    private String date_of_joining;
    private String salary;

    public String getEmp_id() {
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

    public EmployeeCorruptedRecord(String[] data) {
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
        this.emp_id = data[0];
        this.name_prefix = data[1];
        this.first_name = data[2];
        this.middle_initial = data[3];
        this.last_name = data[4];
        this.gender = data[5];
        this.email = data[6];
        this.date_of_birth = data[7];
        this.date_of_joining = data[8];
        this.salary = data[9];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        String and = ",\t";
        sb.append(emp_id);
        sb.append(and);
        sb.append(name_prefix);
        sb.append(and);
        sb.append(first_name);
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
        sb.append(" ]\n");

        return sb.toString();
    }
}
