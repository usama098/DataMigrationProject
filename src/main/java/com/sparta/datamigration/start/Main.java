package com.sparta.datamigration.start;

import com.sparta.datamigration.controller.CSVReader;
import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.EmployeeCleanRecord;
import com.sparta.datamigration.model.EmployeeList;
import com.sparta.datamigration.model.dao.ConnectionFactory;
import com.sparta.datamigration.model.dao.EmployeeDAO;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//         should start with EmployeeManager initialisation
        ArrayList<Employee> list = new ArrayList<>();
        list = CSVReader.readInFile("EmployeeRecords.csv");



        //this can be removed later because it only checks if connection is created
//        EmployeeList list = new EmployeeList();
//        EmployeeCleanRecord record1 = new EmployeeCleanRecord(new String[]{"961538","Mrs.", "Norman", "J", "Siler", "F", "norman_siler@verizon.net", "10/08/1982", "05/04/2013", "176420"});
//        EmployeeCleanRecord record2 = new EmployeeCleanRecord(new String[]{"968722","Mr.", "Freeman", "H", "Lower", "M", "freemanlower@aol.com", "7/2/1997", "11/3/2017", "76823"});
//        EmployeeCleanRecord record3 = new EmployeeCleanRecord(new String[]{"992780","Mr.", "Lawrence", "L", "Macomber", "M", "lawrence_macomber@exxonmobil.com", "9/6/1967", "10/11/1994", "42843"});
//
//        list.insertEmployee(record1, true, false);
//        list.insertEmployee(record2, true, false);
//        list.insertEmployee(record3, true, false);
//
//        EmployeeDAO employees = new EmployeeDAO();
//        employees.createTable();
    }
}
