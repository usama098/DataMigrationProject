package com.sparta.datamigration.model;

public abstract class EmployeeRecord {
    private String emp_id;

    public String getStringEmp_id() {
        return this.emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

}
