package main.java.pack2;

import main.java.com.oopproj.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;
import java.util.*;

//import com.oopproj.Pass_Det;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {




            while(true){

                System.out.printf("\n\n1] Register Passenger Details" +
                        "\n2]Currency Converter" +
                        "\n3]Currency Exchange Information " +
                        "\n4] Enter Manager Details " +
                        "\n5] Enter Employee Details " + //Search Manager by manager id
                        "\n6]Search Employee by ID" +
                        "\n7]Search Employee By Exchange ID" +
                        "\n8]Search Manager by Manager ID" +
                        "\n9]Search Passenger by their Passport Number" +
                        "\n10]Delete Employee Detail using ExchangeID" +
                        "\n11]Print Employee Details" +
                        "\n12]Delete Manager Records" +
                        "\n13]Print Currency Records"+
                        "\n14]Update phone number for the Employee" +
                        "\n15]Update ExchangeID for passenger"+
                        "\n16]Update Manager phone number and salary for the manager"+
                        "\n17]Find salaries higher than the user given input"+
                        "\n18]Update manager using CSV files"+
                        "\n0] Exit! \n\n");

                System.out.println("Choose the  number for the following Operations:");
                Scanner input = new Scanner(System.in);
                int selection;


                selection = input.nextInt();


                switch (selection) {

                case (1): {

                    Passenger pass_det = new Passenger();

                    pass_det.passendet();
                    break;

                }
                case (2): {
                    currencyConverter currencyconverter = new currencyConverter();
                    currencyconverter.main();
                    currency_det currencydet = new currency_det();
                    currencydet.currency();
                    break;

                }

                case (3): {
                    currency_det currencydet = new currency_det();
                    currencydet.searchdetails();
                    break;

                }
                case (4): {
                    manager manage = new manager();
                    manage.inputmanager();
                    break;


                }
                case (5): {
                    employee emps = new employee();
                    emps.EMPLOYEE();
                    break;

                }
                case (7): {
                    employee obj = new employee();
                    employee.searchexchangeid();
                    break;
                }

                case (6): {

                    employee obj = new employee();
                    employee.searchid();
                    break;
                }
                case (8): {
                    manager obj = new manager();
                    manager.searchmanager();
                    break;
                }

                case (9): {
                    Passenger obj = new Passenger();
                    Passenger.searchpass();
                    break;
                }

                case (10): {
                    employee obj = new employee();
                    employee.deleteexchangeid();
                    break;
                }

                case (11): {
                    employee obj = new employee();
                    employee.printdetails();
                    break;
                }

                case(12): {
                    manager obj = new manager();
                    manager.deleteexchangeid();
                    break;
                }
                case(13):{
                    currency_det obj = new currency_det();
                    currency_det.printdetails();
                    break;
                }
                    case(14):{
                    employee obj=new employee();
                    employee.Updatedetails();
                    break;
                }

                    case(15):{
                        Passenger obj = new Passenger();
                        Passenger.Updatepass();
                        break;
                    }

                    case(16):{
                        manager obj = new manager();
                        manager.Updatemandetails();
                        break;
                    }
                    case(17):{
                        manager obj = new manager();
                        manager.comparesal();
                        break;
                }
                    case(18):{
                        manager manage = new manager();
                        manage.csvupdate();
                        break;
                    }


                case (0): {
                    System.out.println("Exit");
                    System.exit(0);

                }
                default:{
                    System.out.println("Invalid Choice");
                }
            }
        }
    }



}
