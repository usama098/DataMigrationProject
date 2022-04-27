package com.sparta.datamigration.model.validate;


import com.sparta.datamigration.util.LoggingClass;

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
            LoggingClass.traceLog("Date could not be converted");
        }

        assert date != null;
        return new Date(date.getTime());

    }

}
