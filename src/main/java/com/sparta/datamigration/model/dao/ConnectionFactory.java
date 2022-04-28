package com.sparta.datamigration.model.dao;

public class ConnectionFactory {
    /*
    private static Connection connection = null;
    public static Connection getConnection() {
        //  connection == null means no connection is made, so it iwll open a a connection
        if(connection == null) {
            try {
                Properties dbProps = new Properties();
                dbProps.load(new FileReader("database.properties"));
                connection = DriverManager.getConnection(
                        dbProps.getProperty("db.url"),
                        dbProps.getProperty("db.username"),
                        dbProps.getProperty("db.password"));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public static void closeConnection(){
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connection = null;
    }
    public static String getInsertSQL(){
        Properties dbProps = new Properties();
        try {
            dbProps.load(new FileReader("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dbProps.getProperty("db.sql.insert");
    }
     */

}
