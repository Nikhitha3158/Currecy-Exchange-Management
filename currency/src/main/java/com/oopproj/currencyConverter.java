package main.java.com.oopproj;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class currencyConverter {

    static String fromCode;
    static String toCode;
    static double amount;
    static Double exchangeRate;
    public static String passexc;

    public static void main() throws IOException {

        HashMap<Integer, String> currencyCodes = new HashMap<Integer, String>();

        //Currency Codes
        currencyCodes.put(1,"USD");
        currencyCodes.put(2,"EUR");
        currencyCodes.put(3,"AED");
        currencyCodes.put(4,"HKD");
        currencyCodes.put(5,"INR");




        Scanner sc = new Scanner(System.in);

        System.out.println("\n**************Currency Converter****************");

        System.out.println("Enter your exchange id!");
        Passenger.ExchangeID = sc.nextLine();
        passexc = Passenger.ExchangeID;

        System.out.println(" Which Currency would you like to convert from?");
        System.out.println("1: USD (US Dollars) \t 2: EUR (Euro) \t 3: AED (UAE Dirham)\t 4: HKD (HongKong Dollar) \t 5: INR (Indian Rupee)");

        fromCode = currencyCodes.get(sc.nextInt());



        System.out.println(" Which Currency would you like to convert to?");
        System.out.println("1: USD \t 2: EUR \t 3: AED \t 4: HKD \t 5: INR");

        toCode = currencyCodes.get(sc.nextInt());

        System.out.println("Amount you want to convert?");
        amount = sc.nextFloat();
        System.out.println("Converting "+amount+" "+fromCode+" to "+ toCode);
        sendHttpGETRequest(fromCode, toCode, amount);

        System.out.println("Thank you for using CurrencyConverter!");
    }

    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {

        DecimalFormat f = new DecimalFormat("00.00");


        //https://api.getgeoapi.com/v2/currency/convert
        //?api_key=e0b3e382af727ded8e1b437a48e05a9c36499a60
        //&from=EUR
        //&to=GBP
        //&amount=10
        //&format=json


        String GET_URL = "https://api.getgeoapi.com/v2/currency/convert?api_key=e0b3e382af727ded8e1b437a48e05a9c36499a60&from=" + fromCode + "&to=" + toCode;
        //String GET_URL = "https://api.exchangerate.io/latest?base=" + toCode + "&symbols" + fromCode;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();


        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){

                response.append(inputLine);
            }in.close();

            JSONObject obj = new JSONObject(response.toString());
//            Double exchangeRate = obj.getJSONObject("rate").getDouble(fromCode);
            exchangeRate=obj.getJSONObject("rates").getJSONObject(toCode).getDouble("rate");
//          System.out.println(obj.getJSONObject("rate"));
            System.out.println("Exchange Rate: 1.00 "+fromCode+" = "+exchangeRate+toCode);
            System.out.println();
            System.out.println(f.format(amount) + fromCode + " = " + f.format(amount*exchangeRate) + toCode);

        }
        else{
            System.out.println("Get Request Failed");
 }
}
}