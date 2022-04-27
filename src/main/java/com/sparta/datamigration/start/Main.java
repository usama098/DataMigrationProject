package com.sparta.datamigration.start;

import com.sparta.datamigration.model.CSVReader;
import com.sparta.datamigration.model.EmployeeList;

public class Main {
    public static void main(String[] args) {
        EmployeeList list = new EmployeeList();
        list = CSVReader.readInFile("EmployeeRecords.csv");

        System.out.println(list.toString());
    }
}
