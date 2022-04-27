package com.sparta.datamigration.model.validate;

import com.sparta.datamigration.util.LoggingClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gender {
    public static boolean validateData(String gender){
        String regex = "M|F";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(gender);
        if(m.matches()){
            return true;
        } else{
            return false;
        }
    }

    // Male = 0, female = 1
    public static boolean convertData(String gender) {
        if (gender.equals("M")) {
            LoggingClass.traceLog("Gender = Male");
            return false;
        } else {
            LoggingClass.traceLog("Gender = Female");
            return true;
        }
    }
}
