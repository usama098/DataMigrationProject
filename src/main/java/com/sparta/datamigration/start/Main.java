package com.sparta.datamigration.start;

import com.sparta.datamigration.controller.CSVReader;
import com.sparta.datamigration.model.Employee;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // should start with EmployeeManager initialisation
        ArrayList<Employee> list = new ArrayList<>();
        list = CSVReader.readInFile("EmployeeRecords.csv");
    }
}
