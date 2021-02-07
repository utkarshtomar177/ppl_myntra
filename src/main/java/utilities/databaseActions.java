/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ark
 */
public class databaseActions {
   
    print print = new print();
    public List selectAllWithLeftJoin(String database , String table , String joinTable , String tableColumn , String joinTableColumn , String symbol){
        try{
            databaseConnection connection = new databaseConnection();
            
            Connection conn = connection.makeMysqlConnection(database);
            
            ResultSet rs = null;
//            System.out.println("before here");
//                DatabaseMetaData meta = (DatabaseMetaData) conn.getMetaData();
//                rs = meta.getTables(null, null, null, new String[] {
//                   "TABLE"
//                });
//                int count = 0;
//                System.out.println("All table names are in test database:");
//                while (rs.next()) {
//                   String tblName = rs.getString("TABLE_NAME");
//                   System.out.println(tblName);
//                   count++;
//                }
            Statement stmt = conn.createStatement();
            System.out.println("1");
//            System.out.print("select * from "+table+" LEFT JOIN " + joinTable+ " ON " + tableColumn + " = " + joinTableColumn + " WHERE " + table+".symbol = '"+symbol+"'"); 
            ResultSet resultSet = stmt.executeQuery("select * from "+table+" LEFT JOIN " + joinTable+ " ON " + tableColumn + " = " + joinTableColumn + " WHERE " + table+".symbol = '"+symbol+"'" );
            String name = null , passKey = null;
            while (resultSet.next()) {
                name = resultSet.getString(4);
                passKey = resultSet.getString(5);
                
//                System.out.println(resultSet.getString(1) + resultSet.getString(2) + resultSet.getString(3) + resultSet.getString(4) + resultSet.getString(5)); //gets the first column's rows.
            }
            System.out.println(name + " " + passKey);
            List<String> credentials = new ArrayList<String>();
            credentials.add(name);credentials.add(passKey);
            
//            
//            ResultSetMetaData md1 = (ResultSetMetaData) resultSet.getMetaData();
//            int counter1 = md1.getColumnCount();
//            String colName1[] = new String[counter1];
//            System.out.println("The column names are as follows:");
//            for (int loop = 1; loop <= counter1; loop++) {
//               colName1[loop-1] = md1.getColumnLabel(loop);
//               System.out.println(colName1[loop-1]);
//            }
//            print.printCompleteResultSet(resultSet);
//            
//            ResultSet resultSet2 = stmt2.executeQuery("select * from credentials");
////            print.printCompleteResultSet(resultSet);
//
//            ResultSetMetaData md = (ResultSetMetaData) resultSet2.getMetaData();
//            int counter = md.getColumnCount();
//            String colName[] = new String[counter];
//            System.out.println("The column names are as follows:");
//            for (int loop = 1; loop <= counter; loop++) {
//               colName[loop-1] = md.getColumnLabel(loop);
//               System.out.println(colName[loop-1]);
//            }
//            
//            System.out.println("2");
//            while (resultSet2.next()) {
//                System.out.println(resultSet2.getString(1) +" "+ resultSet2.getString(2) + " "+ resultSet2.getString(3)  );
//            }
//            while (resultSet.next()) {
//                long id = resultSet.getLong("emp_no");
//                System.out.println(resultSet);
//            }
            conn.close();
            return credentials;
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
   
    
   
    
    
    
   
    
    
}
