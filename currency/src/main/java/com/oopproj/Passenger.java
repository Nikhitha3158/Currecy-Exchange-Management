package main.java.com.oopproj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

public  class Passenger implements conn {
    static Connection connection = null;
//    static String databaseName="oopsproj";
//    static String url="jdbc:mysql://localhost:3306/"+databaseName;
//    static String username="root";
//    static String password="Army@0709";

    static String cust_name;
    static String pass_no;
    static String nationality;
    static String Departure;
    static String arrival;
    static String ExchangeID;

    public static void passendet() throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        connection = DriverManager.getConnection(url, username, password);
        PreparedStatement ps = connection.prepareStatement("insert into passenger values(?, ? ,? ,?,?,?)");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.println("enter Passport number:");
            pass_no = br.readLine();
            System.out.println("enter Customer Name:");
            cust_name = br.readLine();
            System.out.println("enter Passenger nationality:");
            nationality = br.readLine();
            System.out.println("enter Departure location:");
            Departure = br.readLine();
            System.out.println("enter Arrival location:");
            arrival = br.readLine();
            System.out.println("Enter ExcahngeID");
            ExchangeID = br.readLine();
            ps.setString(2, cust_name);
            ps.setString(1, pass_no);
            ps.setString(3, nationality);
            ps.setString(4, Departure);
            ps.setString(5, arrival);
            ps.setString(6, ExchangeID);

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

    public static void searchpass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection connection = DriverManager.getConnection(url, username, password);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Passport Number");
        String pass = sc.nextLine();
        //sc.nextLine();

        try {
            Statement statement = connection.createStatement();

            String sql0 = "select * from passenger where Passport_no = " + pass;
            statement.executeQuery(sql0);
            ResultSet rs = statement.executeQuery(sql0);
            while (rs.next()) {

                System.out.println("\tPassprt Number\t\t\tCustomer Name\t\t\t Nationality\t\t\tDeparture Loc\t\t\tArrival Loc\t\t\t Exchangeid");
                System.out.print("\t   ");
                System.out.print(rs.getString("Passport_no"));
                System.out.print("        ");

                System.out.print(rs.getString("Customer_name"));
                System.out.print("       \t   \t   ");

                System.out.print(rs.getString("Nationality"));
                System.out.print("       \t\t  \t  ");

                System.out.print(rs.getString("Departure"));
                System.out.print("      \t\t    \t  ");

                System.out.print(rs.getString("Arrival"));
                System.out.print("       \t\t\t\t    ");


                System.out.print(rs.getString("ExchangeID"));
                System.out.print("        ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Updatepass() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Passport Number of record to be updated ");
        String empid = sc.nextLine();
        System.out.println("Enter New ExchangeID");
        String exchid = sc.nextLine();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();

        ) {
            String sql = "UPDATE passenger set ExchangeID=" + exchid + " where passport_no=" + empid;
            statement.executeUpdate(sql);
            System.out.println("Update done successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

























