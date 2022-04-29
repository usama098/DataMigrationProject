package com.sparta.datamigration.model;

import java.util.Comparator;

public abstract class Employee implements Comparable<Employee> {
    private String emp_id;


    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public int compareTo(Employee o) {
        String compareEmpID = o.getEmp_id();

        return this.getEmp_id().compareTo(compareEmpID);
    }

    public static Comparator<Employee> idComparator = new Comparator<>() {
        @Override
        public int compare(Employee record1, Employee record2) {
            return record1.compareTo(record2);
        }
    };
}
