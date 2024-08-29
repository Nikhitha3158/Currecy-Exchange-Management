package main.java.com.oopproj;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static main.java.com.oopproj.conn.*;


public class csv_importing_java {
    static public void CSV_1(String filepath) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);
        {
            try {
                BufferedReader lineReader = new BufferedReader(new FileReader(filepath));
                lineReader.readLine();
                String lineText;
                PreparedStatement preparedStatement = connection.prepareStatement("insert into manager values (?,?,?,?)");
                while ((lineText = lineReader.readLine()) != null) {
                    String[] data = lineText.split(",");
                    String manid = data[0];
                    String manname = data[1];
                    String manphone = data[2];
                    String mansal = data[3];

                    preparedStatement.setString(1, manid);
                    preparedStatement.setString(2, manname);
                    preparedStatement.setString(3, manphone);
                    preparedStatement.setString(3, mansal);
                    preparedStatement.addBatch();
                }

                lineReader.close();
                preparedStatement.executeBatch();
                System.out.println("User data uploaded");


            } catch (Exception e) {
                System.out.println("Application error : Database connectivity problem.");
            }
        }
    }
}