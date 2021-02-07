/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import utilities.reader;

/**
 *
 * @author Ark
 */
public class databaseConnection {

    public static Connection makeMysqlConnection(String database) throws IOException, ParseException {
        reader reader = new reader();
        System.out.println("MySQL JDBC Connection Testing ~");
        JSONObject databaseInfo = reader.readFromJSONAndReturnJSONObject("./src/res/database.json", "mysql");
        System.out.println(databaseInfo.get("user"));
        String connectionURL = "jdbc:mysql://" + databaseInfo.get("host").toString() + ":" + databaseInfo.get("port").toString() + "/" + database;
        
//        return DriverManager.getConnection(connectionURL, databaseInfo.get("user").toString(), databaseInfo.get("password").toString());
        try{
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from employees ");
//            while (rs.next()) {
//                long id = rs.getLong("emp_no");
//                System.out.println(id);
//
//                // do something with the extracted data...
//            }
            return DriverManager.getConnection(
                connectionURL, databaseInfo.get("user").toString(), databaseInfo.get("password").toString());

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
}
