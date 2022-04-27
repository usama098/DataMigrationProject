package com.sparta.datamigration.model.validate;

import com.sparta.datamigration.util.LoggingClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiddleInitial{
    public static boolean validateData(String middleInitial){
        String regex = "[A-Z]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(middleInitial);
        if(m.matches()){
            return true;
        } else{
            return false;
        }
    }
    public static String convertData(String middleInitial) {
        LoggingClass.traceLog(middleInitial);
        return middleInitial;
    }
}
