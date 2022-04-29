package com.sparta.datamigration.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static boolean WholeRow(String[] data) {
        boolean valid = true;
        /*
            ID      0   173003
            Pref    1   Mrs.
            FName   2   Willia
            MInit   3   Q
            LName   4   Weigand
            Gender  5   F
            Email   6   willia.weigand@gmail.com
            Birth   7   10/20/1960
            Join    8   7/30/2005
            Salary  9   158292
        */

        String id = data[0];
        String pref = data[1];
        String first = data[2];
        String middle = data[3];
        String last = data[4];
        String gender = data[5];
        String email = data[6];
        String birth = data[7];
        String join = data[8];
        String salary = data[9];

        if ( !employeeID(id) || !prefix(pref) || !name(first) || !initial(middle) || !name(last) || !gender(gender) || !email(email) || !date(birth) || !date(join) || !salary(salary) ) {
            valid = false;
        }

        return valid;
    }

    public static boolean employeeID(String empID){
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

    public static boolean prefix(String prefix){
        if(prefix.equals("Dr.") ||prefix.equals("Esq.")||prefix.equals("Hon.") ||prefix.equals("Jr.")||prefix.equals("Mr.")||prefix.equals("Mrs.")||
                prefix.equals("Ms.")|| prefix.equals("Messrs.")||prefix.equals("Mmes.")|| prefix.equals("Msgr.")||prefix.equals("Prof.")||
                prefix.equals("Rev.")|| prefix.equals("Rt. Hon.")|| prefix.equals("Sr.")||prefix.equals("St.")){
            return true;
        } else {
            return false;
        }
    }

    public static boolean name(String name){
        if(name.matches( "[A-Z][a-z]*" )){
            return true;
        } else{
            return false;
        }
    }

    public static boolean initial(String middleInitial){
        String regex = "[A-Z]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(middleInitial);
        if(m.matches()){
            return true;
        } else{
            return false;
        }
    }

    public static boolean gender(String gender){
        String regex = "M|F";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(gender);
        if(m.matches()){
            return true;
        } else{
            return false;
        }
    }

    public static boolean email(String emailAddress){
        Pattern regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        Matcher regMatcher   = regexPattern.matcher(emailAddress);
        if(regMatcher.matches()){
            return true;
        }else{
            return false;
        }
    }

    public static boolean date(String dateOfBirth){
        boolean valid;
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date d = null;

        try {
            d = df.parse(dateOfBirth);
            valid = true;
        } catch (ParseException e) {
            e.printStackTrace();
            valid = false;
        }

        return valid;
    }

    public static boolean salary(String salary){
        Pattern salaryPattern = Pattern.compile("\\d+");
        if (salary == null) {
            return false;
        }

        return salaryPattern.matcher(salary).matches();
    }

}
