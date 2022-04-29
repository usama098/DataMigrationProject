package com.sparta.datamigration.controller;

import com.sparta.datamigration.model.EmployeeFactory;
import com.sparta.datamigration.model.EmployeeList;
import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.Validate;
import com.sparta.datamigration.util.LoggingClass;
import com.sparta.datamigration.view.EmployeeDisplay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static ArrayList<Employee> readInFile(String fileName){
        // this is where the 3 different ArrayList stored: clean, duplicate, corrupted
        EmployeeList listOfEmployees = new EmployeeList();

        try {
            // we read in the file line by line (row)
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String row;
            br.readLine();

            // we are iterating through the rows, until theres none left
            while ( (row = br.readLine()) != null) {
                // split the row, to handle each data separated
                String[] column = row.split(",");

                // this function checks if each data is valid. if not returns false
                boolean valid = Validate.WholeRow(column);

                // we create either a Clean employee record (which has Date, integer etc fields) or Corrupted employee record (all fields are string)
                EmployeeFactory.createRecord(column, listOfEmployees);
            }

            // call a viewer class to list out the  clean, corrupt and dupe records
            // print out the corrupted, and dupe records
            listOfEmployees.sortLists();
            EmployeeDisplay.printEmployeeList(listOfEmployees);

        } catch (IOException e) {
            LoggingClass.traceLog("CSV file could not be read @CSVReader readInFile. Possibility to return an empty EmployeeList as a result.");
            e.printStackTrace();
        }

        return listOfEmployees.getClean();
    }
}
