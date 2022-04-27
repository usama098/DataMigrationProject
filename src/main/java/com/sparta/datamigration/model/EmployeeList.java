package com.sparta.datamigration.model;

import java.util.ArrayList;

public class EmployeeList {
    private ArrayList<EmployeeRecord> clean = new ArrayList<>();
    private ArrayList<EmployeeRecord> duplicate = new ArrayList<>();
    private ArrayList<EmployeeRecord> corrupted = new ArrayList<>();

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

    public void setCorrupted(ArrayList<EmployeeRecord> corrupted) {
        this.corrupted = corrupted;
    }

    public void insertEmployee(EmployeeRecord employee, boolean valid) {
        if (valid) {
            this.clean.add(employee);
        } else {
            this.corrupted.add(employee);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        System.out.println("Corrupted Data:");
        for (EmployeeRecord record: corrupted) {
            System.out.println(record.toString());
        }

        System.out.println("\nClean Data:");
        for (EmployeeRecord record: clean) {
            System.out.println(record.toString());
        }

        System.out.printf("\n\nNumber of Corrupted record:\t%d\nNumber of Clean record:\t%d", corrupted.size(), clean.size());

        return "";
    }
}