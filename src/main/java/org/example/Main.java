
package org.example;

import org.example.AllInterface.HelperMethod;
import org.example.Tax.Tax;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class Main  {
    static JSONArray jsonArray  = new JSONArray();
    static {
        FileReader fileReader;
        try {
            fileReader = new FileReader("test.json");
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(fileReader);
            jsonArray = new JSONArray(obj.toString());
        } catch (Exception e) {
            System.out.println("We tried");
        }

    }
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            createDocument();
        } catch (Exception e) {
            System.out.println(e);
        }

        Tax tax = new Tax(jsonArray);
        System.out.println(tax);
        System.out.println(tax.additional_income());

    }
    public static void createDocument() throws Exception{
        FileWriter fileWriter = new FileWriter("test.json");
        JSONObject jsonObject = new JSONObject();
        System.out.println("Enter name: ");
        String name = scanner.next();
        jsonObject.put("name",name);
        System.out.println("Enter your salary....");
        int sal = scanner.nextInt();
        jsonObject.put("salary",sal);
        System.out.println("Additional income....");
        int Additional_income = scanner.nextInt();
        jsonObject.put("Additional income",Additional_income);
        jsonArray.put(jsonObject);
        fileWriter.append(jsonArray.toString());
        fileWriter.close();


    }

}