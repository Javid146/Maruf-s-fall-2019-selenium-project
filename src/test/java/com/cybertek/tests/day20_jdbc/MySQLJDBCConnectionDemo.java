package com.cybertek.tests.day20_jdbc;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLJDBCConnectionDemo {
    /**
     * Vytrack Database connection information
     * Username      cybertek_user
     * Password      cybertek_user
     * qa3 url       54.162.64.117
     * port number   3306
     * sid          bitnami_orocrm
     *
     * ME ---> WAITER ---> RESTAURANT KITCHEN
     * JAVA CODE USING SELENIUM ---> CHROME DRIVER --> CHROME BROWSER
     * JAVA CODE USING JDBC     ---> DB DRIVER   ---> DATABASE
     *   jbcs URLs formula "jdbc:database_type:@ip_address:port:sid"*/

    @Test
    public void test() throws SQLException {
        String url = "jdbc:mysql://107.23.27.171:3306/bitnami_orocrm";
        String username = "cybertek_user";
        String password = "cybertek_user";
        // helps connect to the database
        Connection connection = DriverManager.getConnection(url, username, password);///////////////////////////////////
        // helps write queries and execute them
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,/////////////////////////////
                                                         ResultSet.CONCUR_READ_ONLY);
        String query = "select first_name, last_name, description from orocrm_contact";
        // stores the result of the query
        ResultSet resultSet = statement.executeQuery(query);///////////////////////////////////////////////////////////
        //next means until next record/value is available
        while (resultSet.next()) {
            int colCount = resultSet.getMetaData().getColumnCount();//////////////////////////////////////////////////
            for (int i = 1; i <= colCount; i++) {
                String cellValue = resultSet.getString(i);
                System.out.print(cellValue+ "\t");
            }
            System.out.println();
        }
        resultSet.close();
        statement.close();
        connection.close();

////get data from jdbc, put it into map (key and value), add map to list of maps (So you can call by index later).
//        List<Map<String, Object>> caci = new ArrayList<>();
//        int colCount = resultSet.getMetaData().getColumnCount();//get num of columna
//
//        while(resultSet.next()) {
//            Map<String, Object> row = new HashMap<>();
////iterate columns' name (first_name) and their value (Javid) add to map
//            for (int t = 0; t < colCount; t++) {
//                row.put(resultSet.getMetaData().getColumnName(t), resultSet.getObject(t));
//            }
//            caci.add(row);
//        }
    }}

