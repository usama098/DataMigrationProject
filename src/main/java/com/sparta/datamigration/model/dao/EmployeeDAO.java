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


//    private static final String TRUNCATE_TABLE = "TRUNCATE employees";
//
//    private static final String SELECT_EMPLOYEES = "SELECT * FROM employees;";
//    private static final String INSERT_INTO = "INSERT INTO employees " +
//            "(employee_id, title, first_name, middle_initial, last_name, gender, email, birth_date, join_date, salary) " +
//            "VALUES(?,?,?,?,?,?,?,?,?,?);";
//    private static final String DROP_TABLE = "DROP TABLE employees;";
//    private static final String CREATE_TABLE = "CREATE TABLE employees (" +
//            "employee_id VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
//            "title VARCHAR(5),\n" +
//            "first_name VARCHAR(30),\n" +
//            "middle_initial CHAR(1),\n" +
//            "last_name VARCHAR(30),\n" +
//            "gender CHAR(1),\n" +
//            "email VARCHAR(40),\n" +
//            "birth_date DATE,\n" +
//            "join_date DATE,\n" +
//            "salary INTEGER" +
//            ");";


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
