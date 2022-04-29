package com.sparta.datamigration.controller;

import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.dao.EmployeeDAO;

public class EmployeeManager {
    public static void initialise(String fileName) {
//        resetDatabase();
//        readAndWrite(fileName);
    }

    private void resetDatabase() {
        EmployeeDAO employee = new EmployeeDAO();
//        employee.createEmployyesTable();
    }
    // private void resetDatabase()

    // private void readAndWrite()
    //      CSVReader.readInFile(String fileName)
    //          ^ will return ArrayList<EmployeeRecord> which contains the clean non dupe records only

    // public void initialise(String fileName)
    //      create Employee table in database
    //      if said table exist, drop it = resetDatabase()
    //      call readAndWrite()

}
