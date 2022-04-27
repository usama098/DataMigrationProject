package com.sparta.datamigration.model;

import java.util.Comparator;
import java.util.Objects;

public abstract class EmployeeRecord implements Comparable {
    private String employerID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String email;

    public String getEmployerID() {
        return employerID;
    }

    public void setEmployerID(String employerID) {
        this.employerID = employerID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Object o) {
        String compareEmpID = ((EmployeeRecord)o).getEmployerID();

        return this.getEmployerID().compareTo(compareEmpID);
    }

    public static Comparator<EmployeeRecord> idComparator = new Comparator<>() {
        @Override
        public int compare(EmployeeRecord record1, EmployeeRecord record2) {
            return record1.compareTo(record2);
        }
    };
}
