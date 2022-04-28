//package com.sparta.datamigration.model;
//
//import java.util.Comparator;
//
//public class CleanRecord {
//    private String employerID;
//    private String namePrefix;
//    private String firstName;
//    private String middleInitial;
//    private String lastName;
//    private String gender;
//    private String email;
//    private String dateOfBirth;
//    private String dateOfJoin;
//    private String salary;
//
//    public CleanRecord() {
//
//    }
//
//    @Override
//    public String getEmployerID() {
//        return employerID;
//    }
//
//    @Override
//    public void setEmployerID(String employerID) {
//        this.employerID = employerID;
//    }
//
//    @Override
//    public String getNamePrefix() {
//        return namePrefix;
//    }
//
//    @Override
//    public void setNamePrefix(String namePrefix) {
//        this.namePrefix = namePrefix;
//    }
//
//    @Override
//    public String getFirstName() {
//        return firstName;
//    }
//
//    @Override
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    @Override
//    public String getMiddleInitial() {
//        return middleInitial;
//    }
//
//    @Override
//    public void setMiddleInitial(String middleInitial) {
//        this.middleInitial = middleInitial;
//    }
//
//    @Override
//    public String getLastName() {
//        return lastName;
//    }
//
//    @Override
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public boolean isGender() {
//        return gender;
//    }
//
//    public void setGender(boolean gender) {
//        this.gender = gender;
//    }
//
//    @Override
//    public String getEmail() {
//        return email;
//    }
//
//    @Override
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public Date getDateOfJoin() {
//        return dateOfJoin;
//    }
//
//    public void setDateOfJoin(Date dateOfJoin) {
//        this.dateOfJoin = dateOfJoin;
//    }
//
//    public int getSalary() {
//        return salary;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public CleanRecord(String employerID, String namePrefix, String firstName, String middleInitial, String lastName, boolean gender, String email, Date dateOfBirth, Date dateOfJoin, int salary) {
//        this.employerID = employerID;
//        this.namePrefix = namePrefix;
//        this.firstName = firstName;
//        this.middleInitial = middleInitial;
//        this.lastName = lastName;
//        this.gender = gender;
//        this.email = email;
//        this.dateOfBirth = dateOfBirth;
//        this.dateOfJoin = dateOfJoin;
//        this.salary = salary;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        String compareEmpID = ((EmployeeRecord)o).getEmployerID();
//
//        return this.getEmployerID().compareTo(compareEmpID);
//    }
//
//    public static Comparator<EmployeeRecord> idComparator = new Comparator<>() {
//        @Override
//        public int compare(EmployeeRecord record1, EmployeeRecord record2) {
//            return record1.compareTo(record2);
//        }
//    };
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[ ");
//        String and = ", ";
//        sb.append(employerID);
//        sb.append(and);
//        sb.append(namePrefix);
//        sb.append(and);
//        sb.append(firstName);
//        sb.append(and);
//        sb.append(middleInitial);
//        sb.append(and);
//        sb.append(lastName);
//        sb.append(and);
//        sb.append(gender);
//        sb.append(and);
//        sb.append(email);
//        sb.append(and);
//        sb.append(dateOfBirth);
//        sb.append(and);
//        sb.append(dateOfJoin);
//        sb.append(and);
//        sb.append(salary);
//        sb.append(" ]");
//
//        return sb.toString();
//    }
//}
