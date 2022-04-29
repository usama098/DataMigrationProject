package com.sparta.datamigration.model;

public class EmployeeFactory {
    public static void createRecord(String[] data, EmployeeList list) {
        boolean valid = Validate.WholeRow(data);
        Employee record;

        if (valid) {
            record = new EmployeeCleanRecord(data);
        } else {
            record = new EmployeeCorruptedRecord(data);
        }

        boolean duplicate = list.checkDuplicate(data[0]);
        list.insertEmployee(record, valid, duplicate);
    }

}
