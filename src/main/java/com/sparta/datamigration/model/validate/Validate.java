package com.sparta.datamigration.model.validate;

public class Validate {

    public static boolean validateRow(String[] data) {
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

        if ( !EmployeeID.validateData(id) || !Prefix.validateData(pref) || !Name.validateData(first) || !MiddleInitial.validateData(middle) || !Name.validateData(last) || !Gender.validateData(gender) || !EmailAddress.validateData(email) || !DateOf.validateData(birth) || !DateOf.validateData(join) || !Salary.validateData(salary) ) {
            valid = false;
        }

        return valid;
    }



}
