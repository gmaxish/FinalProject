package com.MGrigorovich;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HourAnswers {

    public static void main(String[] args) {

    Map<String, String> myHashMap = new HashMap<>();

        myHashMap.put("1", "На который час формить визит?");
        myHashMap.put("2", "На который час формить визит?");
        myHashMap.put("3", "На который час формить визит?");
        myHashMap.put("4", "На который час оформить визит?");
        myHashMap.put("5", "На который час оформить визит?");
        myHashMap.put("6", "На который час оформить визит?");
        myHashMap.put("7", "На который час оформить визит?");
        myHashMap.put("8", "На который час оформить визит?");
        myHashMap.put("9", "На который час оформить визит?");
        myHashMap.put("10", "На который час оформить визит?");
        myHashMap.put("11", "На который час оформить визит?");
        myHashMap.put("12", "На который час оформить визит?");
        myHashMap.put("13", "На который час оформить визит?");
        myHashMap.put("14", "На который час оформить визит?");
        myHashMap.put("15", "На который час оформить визит?");
        myHashMap.put("16", "На который час оформить визит?");
        myHashMap.put("17", "На который час оформить визит?");
        myHashMap.put("18", "На который час оформить визит?");
        myHashMap.put("19", "На который час оформить визит?");
        myHashMap.put("20", "На который час оформить визит?");
        myHashMap.put("21", "На который час оформить визит?");
        myHashMap.put("22", "На который час оформить визит?");
        myHashMap.put("23", "На который час оформить визит?");
        myHashMap.put("24", "На который час оформить визит?");
        myHashMap.put("25", "На который час оформить визит?");
        myHashMap.put("26", "На который час оформить визит?");
        myHashMap.put("27", "На который час оформить визит?");
        myHashMap.put("28", "На который час оформить визит?");
        myHashMap.put("29", "На который час оформить визит?");
        myHashMap.put("30", "На который час оформить визит?");
        myHashMap.put("31", "На который час оформить визит?");

        System.out.println("Выберите число от 1 до 31");

        Scanner sc = new Scanner(System.in);
        String data = sc.next();

        if (myHashMap.containsKey(data)){
            System.out.println(myHashMap.get(data));
        }else System.out.println("До 31, Карл!");
    }
}
