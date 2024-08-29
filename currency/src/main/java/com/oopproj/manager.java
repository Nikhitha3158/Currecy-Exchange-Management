//package com.oopproj;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.InvocationTargetException;
//import java.sql.*;
//public class manager implements conn{
//    static Connection conn=null;
////        static String databaseName="oopsproj";
////        static String url="jdbc:mysql://localhost:3306/"+databaseName;
////        static String username="root";
////        static String password="Army@0709";
//
//    public  void manager_fun() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
//        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//        conn = DriverManager.getConnection(url, username, password);
//        PreparedStatement ps = conn.prepareStatement("insert into manager values(?, ? ,? ,?)");
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        do {
//            System.out.println("enter Manager ID:");
//            int id = Integer.parseInt(br.readLine());
//            System.out.println("enter Manger Name:");
//            String name = br.readLine();
//            System.out.println("enter Phone number:");
//            int phone_no = Integer.parseInt(br.readLine());
//            System.out.println("enter Manager Salary:");
//            int sal = Integer.parseInt(br.readLine());
//            ps.setInt(1, id);
//            ps.setString(2, name);
//            ps.setInt(3, phone_no);
//            ps.setInt(4, sal);
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
//        public static void searchbyid(int empid) throws SQLException {
//            PreparedStatement stmt = conn.prepareStatement("select * from emp where id=" + empid);
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString(2));
//            }
//        }
//        //conn.close();
//    }


package main.java.com.oopproj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.Scanner;

public class manager implements conn {

    //    static String databaseName="oopsproj";
//    static String url="jdbc:mysql://localhost:3306/"+databaseName;
//    static String username="root";
//    static String password="Army@0709";
    //    String csvfilepath="C:\\Users\\vaish\\OneDrive\\Desktop\\manager.csv\";
    public void inputmanager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("insert into manager values(?, ? ,? ,?)");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int managerid;
        String managername;
        int managerphone;
        int mansal;

        do {
            System.out.println("enter Manager ID:");
            managerid = Integer.parseInt(br.readLine());
            System.out.println("enter Manager Name:");
            managername = br.readLine();
            System.out.println("enter Phone number:");
            managerphone = Integer.parseInt(br.readLine());
            System.out.println("enter Manager Salary:");
            mansal = Integer.parseInt(br.readLine());

            ps.setInt(1, managerid);
            ps.setString(2, managername);
            ps.setInt(3, managerphone);
            ps.setInt(4, mansal);

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

    public static void searchmanager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Manager ID");
        int id = sc.nextInt();
        sc.nextLine();

        try {
            Statement statement = connection.createStatement();
            System.out.println("\n\n\tManager ID\t\t\tManager Name\t\t\tManager Phone Number\t\t\tManager salary\t\t\t");
            System.out.println("   \t\t\t ");
            String sql0 = "select * from manager where ManagerID = " + id;
            statement.executeQuery(sql0);
            ResultSet rs = statement.executeQuery(sql0);
            while (rs.next()) {
                System.out.print(rs.getInt("ManagerId"));
                System.out.print("\t\t\t\t\t\t\t");

                System.out.print(rs.getString("Manager_Name"));
                System.out.print(" \t\t\t\t\t\t");

                System.out.print(rs.getInt("Managerphone_no"));
                System.out.print("  \t\t\t\t\t\t");

                System.out.print(rs.getInt("Manager_sal"));
                System.out.print("        ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteexchangeid() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ManagerID to be deleted");
        String manid = sc.nextLine();

        try {
            Statement statement = connection.createStatement();

            String sql1 = "delete from manager where ManagerID = " + manid;
            statement.executeUpdate(sql1);
            System.out.println("Record is deleted from the table successfully..................");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // method to update manager salary

    public static void Updatemandetails() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter Manager id of record to be updated ");
        int Manid = sc.nextInt();
        System.out.println("Enter New Mobile Number");
        int exchid = sc.nextInt();
        System.out.println("Enter New Salary");
        int salid = sc.nextInt();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();

        ) {
            String sql = "UPDATE manager set Managerphone_no=" + exchid + ",manager_sal= " + salid + " where Managerid=" + Manid;

            statement.executeUpdate(sql);
            System.out.println("Update done successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void comparesal() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Salary to be compared");
        int idsal = sc.nextInt();
        sc.nextLine();

        try {
            Statement statement = connection.createStatement();
            System.out.println("\n\n\tManager ID\t\t\tManager Name\t\t\tManager Phone Number\t\t\tManager salary\t\t\t");
            System.out.println("   \t\t\t ");
            String sql0 = "select * from manager where manager_sal >" + idsal;
            statement.executeQuery(sql0);
            ResultSet rs = statement.executeQuery(sql0);
            while (rs.next()) {
                System.out.print(rs.getInt("ManagerId"));
                System.out.print("\t\t\t\t\t\t\t");

                System.out.print(rs.getString("Manager_Name"));
                System.out.print(" \t\t\t\t\t\t");

                System.out.print(rs.getInt("Managerphone_no"));
                System.out.print("  \t\t\t\t\t\t");

                System.out.print(rs.getInt("Manager_sal"));
                System.out.print("        \n\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void csvupdate() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);
        {
            try {
                csv_importing_java imp = new csv_importing_java();
                imp.CSV_1("C:\\Users\\vaish\\OneDrive\\Desktop\\manager.csv");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
