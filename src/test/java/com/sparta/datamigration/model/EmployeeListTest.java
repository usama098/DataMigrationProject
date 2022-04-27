package com.sparta.datamigration.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeListTest {

    @Test
    @DisplayName(".checkDuplicate() for duplicte empID")
    // 992780
    public void checkDuplicateTest0() {
        EmployeeList list = new EmployeeList();
        EmployeeRecord record1 = EmployeeFactory.createRecord(new String[]{"992780", "Mr.", "Edward", "D", "Stcyr", "false", "edward.stcyr@gmail.com", "03/05/1959", "10/06/1998", "56173"}, true);
        EmployeeRecord record2 = EmployeeFactory.createRecord(new String[]{"992780", "Mr.", "Lawrence", "L", "Macomber", "false", "lawrence.macomber@exxonmobil.com", "06/09/1967", "11/10/1994", "42843"}, true);
        list.insertEmployee(record1, true, false);

        boolean actual = list.checkDuplicate(record2.getEmployerID());
        boolean expected = true;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    @DisplayName(".checkDuplicate() for different empID")
    // 992780
    public void checkDuplicateTest1() {
        EmployeeList list = new EmployeeList();
        EmployeeRecord record1 = EmployeeFactory.createRecord(new String[]{"999341", "Mr.", "Edward", "D", "Stcyr", "false", "edward.stcyr@gmail.com", "03/05/1959", "10/06/1998", "56173"}, true);
        EmployeeRecord record2 = EmployeeFactory.createRecord(new String[]{"999361", "Mr.", "Lawrence", "L", "Macomber", "false", "lawrence.macomber@exxonmobil.com", "06/09/1967", "11/10/1994", "42843"}, true);
        list.insertEmployee(record1, true, false);

        boolean actual = list.checkDuplicate(record2.getEmployerID());
        boolean expected = false;

        Assertions.assertEquals(actual, expected);
    }

}