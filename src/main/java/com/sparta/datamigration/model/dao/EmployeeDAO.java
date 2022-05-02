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

//                   Data Access Object
public class EmployeeDAO {
    private Connection connection = null;

    private static final String TRUNCATE_TABLE = "TRUNCATE employees;";
    private static final String SELECT_EMPLOYEES = "SELECT * FROM employees;";
    private static final String SELECT_WHERE = "SELECT * FROM employees WHERE employee_id=?;";
    private static final String INSERT_INTO = "INSERT INTO employees (employee_id, title, first_name, middle_initial, last_name, gender, email, birth_date, join_date, salary) VALUES(?,?,?,?,?,?,?,?,?,?);";
    private static final String DELETE_FROM = "DELETE FROM employees WHERE employee_id=?;";
    private static final String UPDATE_EMPLOYEE = "UPDATE employees SET title=?, first_name=?, middle_initial=?, last_name=?, gender=?, email=?, birth_date=?, join_date=?, salary=? WHERE employee_id=?";
    private static final String DROP_TABLE = "DROP TABLE employees;";
    private static final String CREATE_TABLE = "CREATE TABLE employees (" +
            "employee_id INTEGER PRIMARY KEY AUTO_INCREMENT," +
            "title VARCHAR(5) NOT NULL," +
            "first_name VARCHAR(30) NOT NULL," +
            "middle_initial CHAR(1)," +
            "last_name VARCHAR(30) NOT NULL," +
            "gender BOOLEAN NOT NULL," +
            "email VARCHAR(40) NOT NULL," +
            "birth_date DATE NOT NULL," +
            "join_date DATE NOT NULL," +
            "salary INTEGER" +
            ");";

    // "CREATE TABLE IF NOT EXISTS employees(employee_id int NOT NULL AUTO_INCREMENT,
    // first varchar(255), last varchar(255), PRIMARY KEY(id))"

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


    public ArrayList<EmployeeCleanRecord> getAllEmployees() {
        ArrayList<EmployeeCleanRecord> employeeList = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection();){
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(SELECT_EMPLOYEES);

            if ( results == null) {
                System.out.println("No data have been found in the 'employees' table");
            } else {
                selectQuery(results);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Could not get records @EmployeeDAO getAllEmployees().");
        }

        return employeeList;
    }

    public void selectQuery(ResultSet results) {
        StringBuilder sb = new StringBuilder();

        try {
            while (results.next()) {
                sb.append("[");
                for (int i=1 ; i<=10 ; i++) {
                    sb.append(results.getString(i));
                }
                sb.append("]\n");
            }
            results.close();
        } catch (SQLException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Could not print the SQL SELECT results @EmployeeDAO selectQuery.");
        }

        System.out.println(sb.toString());
    }


    public void insertEmployee(ArrayList<EmployeeCleanRecord> recordsToInsert) {
        try (Connection connection = ConnectionFactory.getConnection();) {
            PreparedStatement prepStatement = connection.prepareStatement(INSERT_INTO);

            for (EmployeeCleanRecord record: recordsToInsert) {
                insertQuery(record, prepStatement);
            }
            prepStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Could not insert records into employees table @EmployeeDAO insertEmployee().");
        }
    }


    /*
            private String emp_id;
            private int integer_id;
            private String name_prefix;
            private String first_name;
            private String middle_initial;
            private String last_name;
            private boolean gender;     // Male = 0, female = 1
            private String email;
            private Date date_of_birth;
            private Date date_of_joining;
            private int salary;
     */
    public void insertQuery(EmployeeCleanRecord record, PreparedStatement statement) {
        try {
            statement.setInt(1, record.getInteger_id());
            statement.setString(2, record.getName_prefix());
            statement.setString(3, record.getFirst_name());
            statement.setString(4, record.getMiddle_initial());
            statement.setString(5, record.getLast_name());
            statement.setBoolean(6, record.isGender());
            statement.setString(7, record.getEmail());
            statement.setDate(8, record.getDate_of_birth());
            statement.setDate(9, record.getDate_of_joining());
            statement.setInt(10, record.getSalary());
        } catch (SQLException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Could not insert record data into SQL code @EmployeeDAO insertQuery().");
        }

    }


    public boolean deleteEmployeeById(int empID) {
        boolean successful = false;

        try (Connection connection = ConnectionFactory.getConnection();){
            PreparedStatement prepStatement = connection.prepareStatement(DELETE_FROM);
            prepStatement.setInt(1, empID);
            successful = true;

        } catch (SQLException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Could not delete record by ID @ EmployeeDAO deleteEmployeeById().");
        }

        return successful;
    }


    public boolean updateEmployee(int recordIDToUpdate, String title, String firstName, String middleInitial, String lastName, boolean gender, String email, Date birth, Date join, int salary) {
        boolean successful = false;

        try (Connection connection = ConnectionFactory.getConnection();){
            PreparedStatement prepStatement = connection.prepareStatement(UPDATE_EMPLOYEE);
            prepStatement.setString(1, title);
            prepStatement.setString(2, firstName);
            prepStatement.setString(3, middleInitial);
            prepStatement.setString(4, lastName);
            prepStatement.setBoolean(5, gender);
            prepStatement.setString(6, email);
            prepStatement.setDate(7, birth);
            prepStatement.setDate(8, join);
            prepStatement.setInt(9, salary);
            prepStatement.setInt(10, recordIDToUpdate);

            prepStatement.executeUpdate();
            successful = true;

        } catch (SQLException e) {
            e.printStackTrace();
            LoggingClass.errorLog("Could not update record @ EmployeeDAO updateEmployee().");
        }
        return successful;
    }

}
