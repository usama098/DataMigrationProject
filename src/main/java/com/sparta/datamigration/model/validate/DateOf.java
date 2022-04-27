package com.sparta.datamigration.model.validate;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Input date format:      MM/dd/yyyy
        10/20/1960
        7/30/2005

    Output date format:     YYYY-MM-DD
        https://dev.mysql.com/doc/refman/8.0/en/datetime.html
 */

public class DateOf {
    public static boolean validateData(String dateOfBirth){
        boolean isValid;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date d = null;

        try {
            d = df.parse(dateOfBirth);
            isValid = true;
        } catch (ParseException  e) {
            e.printStackTrace();
            isValid = false;
        }

        return isValid;
    }

    public static Date convertData(String dateOfBirth) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date = null;

        try {
            date = df.parse(dateOfBirth);

        } catch (ParseException  e) {
            e.printStackTrace();
        }

        assert date != null;
        return new Date(date.getTime());
    }

    public static class EmailAddress {
        public static boolean validateData(String emailAddress){
            Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
            Matcher regMatcher   = regexPattern.matcher(emailAddress);
            if(regMatcher.matches()){
                return true;
            }else{
                return false;
            }
        }
        public static String convertData(String emailAddress) {
            return emailAddress;
        }
    }
}
