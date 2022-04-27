package com.sparta.datamigration.model.validate;

import com.sparta.datamigration.util.LoggingClass;

public class Prefix {
    public static boolean validateData(String prefix){
        if(prefix.equals("Dr.") ||prefix.equals("Esq.")||prefix.equals("Hon.") ||prefix.equals("Jr.")||prefix.equals("Mr.")||prefix.equals("Mrs.")||
                prefix.equals("Ms.")|| prefix.equals("Messrs.")||prefix.equals("Mmes.")|| prefix.equals("Msgr.")||prefix.equals("Prof.")||
                prefix.equals("Rev.")|| prefix.equals("Rt. Hon.")|| prefix.equals("Sr.")||prefix.equals("St.")){
            return true;
        } else {
            return false;
        }
    }
    public static String convertData(String prefix) {
        LoggingClass.traceLog(prefix);
        return prefix;
    }
}
