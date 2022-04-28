package com.sparta.datamigration.model.dao;

// we can create own Interface to sum up the CURD interactions
// if we happened to increase and have more different tables in DB
//  public class EmployeeDao implements Dao<Employee>{

/*
    Remember to use try-with-resources to ensure connections are
    closed as soon as they have been used, if appropriate.

    It is easy to make this process very slow by creating a
    new connection for each record – consider how to ensure
    that you reuse connections.
        -> shared connection
        -> auto commit off, we commit at the end of inserting
        -> prepared statement instead of statement
        -> batch process [?? self note: watch video for it]
 */

//      This class is basically will contain the all the SQL code
//      which we hide behind the methods
//      and can easily call that method just by passing on the parametres [example first_name]

//                   Data Access Object
public class EmployeeDAO {

    // Employee getEmployeeById()


    // ArrayList<Employee> getAllEmployees()


    // boolean deleteEmployeeById()


    // boolean updateEmployee
    /*  EXAMPLE:
            public void update(User user, String[] params) {
                user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
                user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));
     */

}
