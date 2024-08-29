
//package com.oopproj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.InvocationTargetException;
//import java.sql.*;
//import java.util.Scanner;
//
//public class employee implements conn
//{
//
////    static String databaseName="oopsproj";
////    static String url="jdbc:mysql://localhost:3306/"+databaseName;
////    static String username="root";
////    static String password="Army@0709";
//
//    public void EMPLOYEE() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
//        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//        Connection connection = DriverManager.getConnection(url, username, password);
//        PreparedStatement ps = connection.prepareStatement("insert into employee values(?, ? ,? ,?,?)");
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int empid;
//        String empname;
//        int phone_no;
//        String exchangeID;
//        int man_id;
//
//        do {
//            System.out.println("enter Employee ID:");
//            empid = Integer.parseInt(br.readLine());
//            System.out.println("enter Employee Name:");
//            empname = br.readLine();
//            System.out.println("enter Phone number:");
//            phone_no = Integer.parseInt(br.readLine());
//            System.out.println("enter ExchangeID:");
//            exchangeID = br.readLine();
//            System.out.println("enter ManagerID:");
//            man_id = Integer.parseInt(br.readLine());
//            ps.setInt(1, empid);
//            ps.setString(2, empname);
//            ps.setInt(3, phone_no);
//            ps.setString(4, exchangeID);
//            //ps.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
//            ps.setInt(5, man_id);
//
//            int i = ps.executeUpdate();
//            if (i != 0) {
//                System.out.println(i + " records affected");
//            }
//            System.out.println("Do you want to continue: y/n");
//            String s = br.readLine();
//            if (s.startsWith("n")) {
//                break;
//            }
//        } while (true);
//    }
//    public static void accessManag()  throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
//        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//        Connection connection = DriverManager.getConnection(url, username, password);
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Employee ID");
//        int id = sc.nextInt();
//        sc.nextLine();
//
//        try {
//            Statement statement = connection.createStatement();
//
//            String sql0 = "select * from employee where EmpID = " + id;
//            statement.executeQuery(sql0);
//            ResultSet rs = statement.executeQuery(sql0);
//            while (rs.next()) {
//                System.out.println(rs.getInt("EmpID"));
//                System.out.println("        ");
//
//                System.out.println(rs.getString("Empname"));
//                System.out.println("        ");
//
//                System.out.println(rs.getInt("Empph_no"));
//                System.out.println("        ");
//
//                System.out.println(rs.getString("ExchangeID"));
//                System.out.println("        ");
//
//                System.out.println(rs.getInt("MANAGERID"));
//                System.out.println("        ");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//}
//}
//
//    //connection.close();
//
//
//    }
//
////    public static void searchbyempid() throws SQLException {
////
////        System.out.println("Please enter Employee ID: ");
////        Scanner sc = new Scanner(System.in);
////        int empid = sc.nextInt();
////
////
////        PreparedStatement stmt = connection.prepareStatement("select * from employee where EmpID = ?");
////        stmt.setInt(1,empid);
////        ResultSet rs = stmt.executeQuery();
////        while (rs.next()) {
////            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3)+ " "+ rs.getInt(4));
////        }
////    }
//
//
package main.java.com.oopproj;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class employee implements conn {

//    static String databaseName="oopsproj";
//    static String url="jdbc:mysql://localhost:3306/"+databaseName;
//    static String username="root";
//    static String password="Army@0709";

    public void EMPLOYEE() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("insert into employee values(?, ? ,? ,?,?)");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int empid;
        String empname;
        int phone_no;
        String exchangeID;
        int man_id;

        do {
            System.out.println("enter Employee ID:");
            empid = Integer.parseInt(br.readLine());
            System.out.println("enter Employee Name:");
            empname = br.readLine();
            System.out.println("enter Phone number:");
            phone_no = Integer.parseInt(br.readLine());
            System.out.println("enter ExchangeID:");
            exchangeID = br.readLine();
            System.out.println("enter ManagerID:");
            man_id = Integer.parseInt(br.readLine());
            ps.setInt(1, empid);
            ps.setString(2, empname);
            ps.setInt(3, phone_no);
            ps.setString(4, exchangeID);

            ps.setInt(5, man_id);

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

    public static void searchid() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID");
        int id = sc.nextInt();
        sc.nextLine();

        try {
            Statement statement = connection.createStatement();

            String sql0 = "select * from employee where EmpID = " + id;
            statement.executeQuery(sql0);
            ResultSet rs = statement.executeQuery(sql0);
            while (rs.next()) {

                System.out.println("\n\n\tEmployee ID\t\t\tEmployee Name\t\t\tEmployee Phone No\t\t\tExchange Id\t\t\tManager ID");
                System.out.print("    \t  ");
                System.out.print(rs.getInt("EmpID"));
                System.out.print("\t      \t\t\t\t");

                System.out.print(rs.getString("Empname"));
                System.out.print("\t\t");

                System.out.print(rs.getInt("Empph_no"));
                System.out.print("\t\t\t\t\t");

                System.out.print(rs.getString("ExchangeID"));
                System.out.print("\t   \t\t\t\t\t\t");

                System.out.print(rs.getInt("MANAGERID"));
                System.out.println("        ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchexchangeid() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Exchange ID");
        String exid = sc.nextLine();
        //sc.nextLine();

        try {
            Statement statement = connection.createStatement();

            String sql0 = "select * from employee where ExchangeID = " + exid;
            statement.executeQuery(sql0);
            ResultSet rs = statement.executeQuery(sql0);
            while (rs.next()) {

                System.out.println("\n\n\tEmployee ID\t\t\tEmployee Name\t\t\tEmployee Phone No\t\t\tExchange Id\t\t\tManager ID");
                System.out.print("    \t  ");
                System.out.print(rs.getInt("EmpID"));
                System.out.print("\t      \t\t\t\t");

                System.out.print(rs.getString("Empname"));
                System.out.print("\t\t\t");

                System.out.print(rs.getInt("Empph_no"));
                System.out.print("\t\t\t");

                System.out.print(rs.getString("ExchangeID"));
                System.out.print("\t   \t\t\t");

                System.out.print(rs.getInt("MANAGERID"));
                System.out.println("        ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteexchangeid() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Exchange ID to be deleted");
        String exid = sc.nextLine();
        //sc.nextLine();

        try {
            Statement statement = connection.createStatement();

            String sql0 = "delete from employee where ExchangeID = " + exid;
            statement.executeUpdate(sql0);
            System.out.println("Record is deleted from the table successfully..................");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printdetails() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        try {
            Statement statement = connection.createStatement();

            String sql02 = "select * from employee";
            statement.executeQuery(sql02);
            ResultSet rs = statement.executeQuery(sql02);
            while (rs.next()) {
                System.out.print(rs.getInt("EmpID"));
                System.out.print("  ");
                System.out.print(rs.getString("Empname"));
                System.out.print("  ");
                System.out.print(rs.getInt("Empph_no"));
                System.out.print("  ");
                System.out.print(rs.getString("ExchangeID"));
                System.out.print("  ");
                System.out.print(rs.getInt("MANAGERID"));
                System.out.println("        ");


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void Updatedetails() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee id of record to be updated ");
        int empid = sc.nextInt();
        System.out.println("Enter New Mobile Number");
        int exchid = sc.nextInt();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();

        ) {
            String sql = "UPDATE employee set empph_no=" + exchid + " where empid=" + empid;
            statement.executeUpdate(sql);
            System.out.println("Update done successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

