package org.example.Tax;

import org.example.AllInterface.HelperMethod;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Tax implements HelperMethod {
    @Override
    public String toString() {
        return "Tax{" +
                "jsonArray=" + jsonArray +
                '}';
    }

    JSONArray jsonArray;

    public boolean checkProfit(JSONObject jsonObject){
        return Integer.parseInt(jsonObject.get("Additional income").toString()) > 500;
    }
    public Tax(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @Override
    public boolean checkData() {
        return jsonArray.isEmpty();
    }

    @Override
    public int checkCountElem() {
        return jsonArray.length();
    }

    @Override
    public HashMap<String, List<Object>> additional_income() {
        List<JSONObject> list = new ArrayList<>();
        for (Object obj:jsonArray){
            JSONObject jsonObject = (JSONObject) obj;
            list.add(jsonObject);
        }
        if (list.size()>1){
            list = list.stream().filter(this::checkProfit).toList();
            HashMap<String,List<Object>> hashMap = new HashMap<>();
            hashMap.put(String.valueOf(list.size()), Collections.singletonList(list));
            return hashMap;
        }
        return null;



    }
    public static class Person{
        String name;
        int salary,additional_income;

        public Person(String name, int salary, int additional_income) {
            this.name = name;
            this.salary = salary;
            this.additional_income = additional_income;
        }
    }
}
