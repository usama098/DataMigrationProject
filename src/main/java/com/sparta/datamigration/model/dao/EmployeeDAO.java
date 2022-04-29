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

import com.sparta.datamigration.model.EmployeeCleanRecord;
import com.sparta.datamigration.util.LoggingClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

//                   Data Access Object
//                   Data Access Object
public class EmployeeDAO {
    private Connection connection = null;

    private static final String TRUNCATE_TABLE = "TRUNCATE employees";
    private static final String SELECT_EMPLOYEES = "SELECT * FROM employees;";
    private static final String INSERT_INTO = "INSERT INTO employees (employee_id, title, first_name, middle_initial, last_name, gender, email, birth_date, join_date, salary) VALUES(?,?,?,?,?,?,?,?,?,?);";
    private static final String DROP_TABLE = "DROP TABLE employees;";
    private static final String CREATE_TABLE = "CREATE TABLE employees (" +
            "employee_id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
            "title VARCHAR(5) NOT NULL,\n" +
            "first_name VARCHAR(30) NOT NULL,\n" +
            "middle_initial CHAR(1),\n" +
            "last_name VARCHAR(30) NOT NULL,\n" +
            "gender BOOLEAN NOT NULL,\n" +
            "email VARCHAR(40) NOT NULL,\n" +
            "birth_date DATE NOT NULL,\n" +
            "join_date DATE NOT NULL,\n" +
            "salary INTEGER" +
            ");";

    public void createTable() {
        System.out.println("within creat table");
        try {
            // we connect to the database
            connection = ConnectionFactory.getConnection();

            // check if we have employees table
            //      --> drop/truncate
            // create table
            if (tableExists()) {
                System.out.println("employees table exists, so we drop it");
                /*
                    DROP vs TRUNCATE table

                    DROP        =   deletes the table structure from the database, along with any data stored in the table, constraints, and triggers related to the table.
                    TRUNCATE    =   deletes records from a table without removing table structure
                        (!) might cause issue if the table has different data settings!
                        TRUNCATE is faster than DROP table

                   source:
                   https://learnsql.com/blog/difference-between-truncate-delete-and-drop-table-in-sql/
                 */
                dropTable();
//                truncateTable();

                //logging.trace?debug? employee table already exists,data have been truncated
            }
                Statement statement = connection.createStatement();
                statement.executeLargeUpdate(CREATE_TABLE);
                connection.close();
            System.out.println("employees table have been created");


        } catch (SQLException e) {
            e.printStackTrace();
            // logging again.
        } finally {
            ConnectionFactory.closeConnection();
        }
    }

    private boolean tableExists() {
        try {
            connection = ConnectionFactory.getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();

            ResultSet resultSet = databaseMetaData.getTables(null, null, "employees", null);
            if (resultSet.next()) {
                return true;
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not get MetaData @EmployeeDAO tableExists()");
        }
        return false;
    }

    private void dropTable() {
        // with single statements like create/drop table is fine to use just Statement
        try (Statement statement = connection.createStatement();){
            statement.executeLargeUpdate(DROP_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
            // logging, table could not be dropped
        }
    }

    private void truncateTable(){
        //
        try (PreparedStatement prepStatement = connection.prepareStatement(TRUNCATE_TABLE);){
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // logging table could not truncate table
        }
    }

    // Employee getEmployeeById()


    /*
    not finished yet, need to finsih selectQuery(results); first
     */
    // ArrayList<Employee> getAllEmployees()
    public ArrayList<EmployeeCleanRecord> getAllEmployees() {
        ArrayList<EmployeeCleanRecord> employeeList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(SELECT_EMPLOYEES);

            if ( results != null) {
                // maybe can use lambda expression here?
                selectQuery(results);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // logging could not get records from employees @
        }

        if (employeeList.size() < 1) {
            System.out.println("No data have been found in the 'employees' table");
        } else {
            // call selectQuery to print them out
        }

        return employeeList;
    }

    public void selectQuery(ResultSet results) {
        StringBuilder sb = new StringBuilder();

        try {
            while (results.next()) {
                // 1 - 10
                results.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // logging
        }

    }


    // create insertEmployee
    // .executeUpdate(INSERT_INTO)


    // boolean deleteEmployeeById()


    // boolean updateEmployee
    /*  EXAMPLE:
            public void update(User user, String[] params) {
                user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
                user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));
     */

}
