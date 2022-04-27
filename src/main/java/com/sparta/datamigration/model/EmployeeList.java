package com.sparta.datamigration.model;

import java.util.*;

public class EmployeeList {
    private ArrayList<EmployeeRecord> clean = new ArrayList<>();
    private ArrayList<EmployeeRecord> duplicate = new ArrayList<>();
    private ArrayList<EmployeeRecord> corrupted = new ArrayList<>();
    private Set<String> empID = new HashSet<>();

    public ArrayList<EmployeeRecord> getClean() {
        return clean;
    }

    public void setClean(ArrayList<EmployeeRecord> clean) {
        this.clean = clean;
    }

    public ArrayList<EmployeeRecord> getDuplicate() {
        return duplicate;
    }

    public void setDuplicate(ArrayList<EmployeeRecord> duplicate) {
        this.duplicate = duplicate;
    }

    public ArrayList<EmployeeRecord> getCorrupted() {
        return corrupted;
    }

    public Set<String> getEmpID() {
        return empID;
    }

    public void setEmpID(Set<String> empID) {
        this.empID = empID;
    }

    public void setCorrupted(ArrayList<EmployeeRecord> corrupted) {
        this.corrupted = corrupted;
    }

    public void insertEmployee(EmployeeRecord employee, boolean valid, boolean duplicate) {
        if (duplicate) {
            this.duplicate.add(employee);
        } else if (valid) {
            this.clean.add(employee);
            this.empID.add(employee.getEmployerID());
        } else {
            this.corrupted.add(employee);
        }

    }

    public boolean checkDuplicate(String empID) {
        return this.empID.contains(empID);
    }

    @Override
    public String toString() {

//        System.out.println("\n\nCorrupted Data:\n");
//        for (EmployeeRecord record: corrupted) {
//            System.out.println(record.toString());
//        }
//
//        System.out.println("\nClean Data:");
//        for (EmployeeRecord record: clean) {
//            System.out.println(record.toString());
//        }
//
//
//        System.out.println("\nDuplicate Data:");
//        for (EmployeeRecord record: duplicate) {
//            System.out.println(record.toString());
//        }
//
//        System.out.printf("\n\nNumber of Corrupted record:\t%d\nNumber of Clean record:\t%d\nNumber of Duplicate record: %d", corrupted.size(), clean.size(), duplicate.size());


        StringBuilder sb = new StringBuilder();
        sb.append("Number of Corrupted record:\t");
        sb.append(corrupted.size());
        sb.append("\nNumber of Clean record:\t");
        sb.append(clean.size());
        sb.append("\nNumber of Duplicate record:\t");
        sb.append(duplicate.size());

        return sb.toString();
    }

}

