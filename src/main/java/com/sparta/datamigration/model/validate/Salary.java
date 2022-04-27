package com.sparta.datamigration.model.validate;

import java.util.regex.Pattern;

public class Salary {
    public static boolean validateData(String salary){
        Pattern salaryPattern = Pattern.compile("\\d+");
        if (salary == null) {
            return false;
        }

        return salaryPattern.matcher(salary).matches();
    }

    public static int convertData(String salary) {
        return Integer.parseInt(salary);
    }
}
