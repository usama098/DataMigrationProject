package com.sparta.datamigration.model.validate;

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
            return false;
        } else {
            return true;
        }
    }
}
