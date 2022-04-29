package com.sparta.datamigration.start;

import com.sparta.datamigration.controller.CSVReader;
import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.dao.ConnectionFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // should start with EmployeeManager initialisation
//        ArrayList<Employee> list = new ArrayList<>();
//        list = CSVReader.readInFile("EmployeeRecords.csv");

        //this can be removed later because it only checks if connection is created
        ConnectionFactory.getConnection();
    }
}
