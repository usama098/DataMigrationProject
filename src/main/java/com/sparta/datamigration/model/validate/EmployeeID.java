package com.sparta.datamigration.model.validate;

import com.sparta.datamigration.util.LoggingClass;

public class EmployeeID {
    public static boolean validateData(String empID){
        if (empID.length() != 6) {
            return false;
        }

        for (int i=0; i<empID.length(); i++) {
            char c = empID.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }


        return true;
    }

    public static String convertData(String empID) {
        LoggingClass.traceLog(empID);
        return empID;
    }
}
