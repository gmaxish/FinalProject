package com.MGrigorovich;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

public class WorkingDays {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE");

        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        int currentWeekDay = calendar.get(Calendar.DAY_OF_WEEK);


        LinkedList list = new LinkedList();
        for (int i = currentDay; i < calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {

            if (i > currentDay) {
                String j = String.valueOf(i);
                list.add(j);
                System.out.println(j);
                System.out.println(currentWeekDay);
            }
        }




    for(int i = 0;i< 10;i++) {
        calendar.add(Calendar.DATE, 1);
        System.out.println(formatter.format(calendar.getTime()));
    }
}
}

