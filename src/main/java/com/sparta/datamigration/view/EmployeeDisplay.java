package com.sparta.datamigration.view;

import com.sparta.datamigration.model.Employee;
import com.sparta.datamigration.model.EmployeeList;

import java.util.ArrayList;

public class EmployeeDisplay {

    /*
        Provide a simple user interface to display the results of reading the file –
        how many unique, clean records there are, how many duplicates,
        how many records with missing fields, possibly display the questionable records.

     */

    public static void printEmployeeList(EmployeeList list) {

        /*
        maybe add an if statement to print "no records to listed" if one of the array is empty
         */
        ArrayList<Employee> clean = list.getClean();
        ArrayList<Employee> duplicate = list.getDuplicate();
        ArrayList<Employee> corrupted = list.getCorrupted();
        StringBuilder sb = new StringBuilder();

        sb.append("\n\nCorrupted Records:\n");
        for (Employee record: corrupted) {
            sb.append(record.toString());
        }
        sb.append("\n\nDuplicate Records:\n");
        for (Employee record: duplicate) {
            sb.append(record.toString());
        }

//        sb.append("\n\nClean Records:\n");
//        for (Employee record: clean) {
//            sb.append(record.toString());
//        }

        sb.append("\n\nNumber of Corrupted record:\t");
        sb.append(corrupted.size());
        sb.append("\nNumber of Clean record:\t");
        sb.append(clean.size());
        sb.append("\nNumber of Duplicate record:\t");
        sb.append(duplicate.size());

        System.out.println(sb);
    }
}
