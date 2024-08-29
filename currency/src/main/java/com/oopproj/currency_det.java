package main.java.com.oopproj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

import static main.java.com.oopproj.currencyConverter.*;


public class currency_det implements conn {


    String exchangeID;

    public void currency() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("insert into currency values(? ,? ,?,? ,?)");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        currencyConverter currencyConverter = new currencyConverter();
        String from = fromCode;
        String to = toCode;
        double amount1 = amount;
        //System.out.println("TEST" + amount);
        exchangeID = passexc;



        do {
            ps.setString(2, from);
            ps.setString(3, to);
            ps.setDouble(4, amount1);
            ps.setString(1, exchangeID);
            ps.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

            int i = ps.executeUpdate();
            if (i != 0) {
                System.out.println(i + " records affected");
            }
            System.out.println("Do you want to continue: y/n");
            String s = br.readLine();
            if (s.startsWith("n")) {
                break;
            }
        } while (true);


    }

    public void searchdetails() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        try {
            Statement statement = connection.createStatement();

            System.out.println("Enter Exchange ID");
            Scanner sc = new Scanner(System.in);
            String excid = sc.nextLine();
            //System.out.println("TEST" + excid);
            String sql0 = "select * from currency where ExchangeID = " + excid;
            statement.executeQuery(sql0);
            ResultSet rs = statement.executeQuery(sql0);
            System.out.print("ExchangeID       Converting_From       Converting_To              Amount\n          TimeStamp");
            System.out.println("  \t  ");
            while (rs.next()) {
                System.out.print("      ");
                System.out.print(rs.getString("ExchangeID"));
                System.out.print("               ");

                System.out.print(rs.getString("Converting_From"));
                System.out.print("               ");

                System.out.print(rs.getString("Converting_To"));
                System.out.print("               ");

                System.out.print(rs.getDouble("AMOUNT"));
                System.out.print("         ");

                System.out.print(rs.getTimestamp("TimeStamp"));


                break;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printdetails() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        try {
            Statement statement = connection.createStatement();

            String sql02 = "select * from currency";
            statement.executeQuery(sql02);
            ResultSet rs = statement.executeQuery(sql02);
            while (rs.next()) {
                System.out.print(rs.getString("ExchangeID"));
                System.out.print("  ");
                System.out.print(rs.getString("Converting_from"));
                System.out.print("  ");
                System.out.print(rs.getString("Converting_to"));
                System.out.print("  ");
                System.out.print(rs.getInt("Amount"));
                System.out.print("  ");
                System.out.println("        ");


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}