package com.sparta.datamigration.model;

import com.sparta.datamigration.model.validate.DateOf;
import com.sparta.datamigration.model.validate.Gender;
import com.sparta.datamigration.model.validate.Salary;

import java.sql.Date;

public class EmployeeFactory {
    public static EmployeeRecord createRecord(String[] data, boolean valid) {
        EmployeeRecord record;
        if (valid) {
            /*
            ID      0   173003
            Pref    1   Mrs.
            FName   2   Willia
            MInit   3   Q
            LName   4   Weigand
            Gender  5   F
            Email   6   willia.weigand@gmail.com
            Birth   7   10/20/1960
            Join    8   7/30/2005
            Salary  9   158292
             */
            boolean gender = Gender.convertData(data[5]);
            Date birth = DateOf.convertData(data[7]);
            Date join = DateOf.convertData(data[8]);
            int salary = Salary.convertData(data[9]);

            record = new CleanRecord(data[0], data[1], data[2], data[3], data[4], gender, data[6],  birth, join, salary);
        } else {
            record = new CorruptedRecord(data[0], data[1], data[2], data[3], data[4], data[5], data[6],  data[7], data[8], data[9]);
        }

        return record;
    }
}
