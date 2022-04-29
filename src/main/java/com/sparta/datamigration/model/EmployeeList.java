package com.sparta.datamigration.model;

import java.util.*;

public class EmployeeList {
    private ArrayList<Employee> clean = new ArrayList<>();
    private ArrayList<Employee> duplicate = new ArrayList<>();
    private ArrayList<Employee> corrupted = new ArrayList<>();
    private Set<String> empID = new HashSet<>();

    public ArrayList<Employee> getClean() {
        return clean;
    }

    public void setClean(ArrayList<Employee> clean) {
        this.clean = clean;
    }

    public ArrayList<Employee> getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(ArrayList<Employee> duplicate) {
        this.duplicate = duplicate;
    }

    public ArrayList<Employee> getCorrupted() {
        return corrupted;
    }

    public Set<String> getEmpID() {
        return empID;
    }

    public void setEmpID(Set<String> empID) {
        this.empID = empID;
    }

    public void setCorrupted(ArrayList<Employee> corrupted) {
        this.corrupted = corrupted;
    }

    public void insertEmployee(Employee employee, boolean valid, boolean duplicate) {
        if (duplicate) {
            this.duplicate.add(employee);
        } else if (valid) {
            this.clean.add(employee);
            this.empID.add(employee.getEmp_id());
        } else {
            this.corrupted.add(employee);
        }

    }

    public boolean checkDuplicate(String empID) {
        return this.empID.contains(empID);
    }

    public void sortLists() {
        this.clean.sort(Employee.idComparator);
        this.duplicate.sort(Employee.idComparator);
        this.corrupted.sort(Employee.idComparator);
    }

}

