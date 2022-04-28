package com.sparta.datamigration.controller;

import com.sparta.datamigration.model.CleanRecord;
import com.sparta.datamigration.model.EmployeeFactory;
import com.sparta.datamigration.model.EmployeeList;
import com.sparta.datamigration.model.EmployeeRecord;
import com.sparta.datamigration.model.validate.*;
import com.sparta.datamigration.util.LoggingClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

    public static ArrayList<EmployeeRecord> readInFile(String fileName){
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
                boolean valid = Validate.validateRow(column);

                // we create either a Clean employee record (which has Date, integer etc fields) or Corrupted employee record (all fields are string)
                EmployeeRecord recordToAdd = EmployeeFactory.createRecord(column, valid);

                // check if its duplicate record
                boolean duplicate = listOfEmployees.checkDuplicate(column[0]);

                // we insert this newly created record to the corresponding list [line 23]
                listOfEmployees.insertEmployee(recordToAdd, valid, duplicate);

                // call a viewer class to list out the  clean, corrupt and dupe records
                // print out the corrupted, and dupe records

            }



        } catch (IOException e) {
            LoggingClass.traceLog("employees.csv file read");
            e.printStackTrace();
        }

        return listOfEmployees.getClean();
    }
}
