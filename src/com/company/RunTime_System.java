package com.company;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by dell on 2016/10/14.
 */
public class RunTime_System {
    public static void main(String arg[]) {
        Runtime runTime = Runtime.getRuntime();
        System.out.println("JVM的最大内存：" + runTime.maxMemory());
        System.out.println("JVM的空闲内存：" + runTime.freeMemory());
        String a = "1";
        for (int i = 0; i < 1000; i++) {
            a += i;
        }
        System.out.println("JVM的空闲内存：" + runTime.freeMemory());
        runTime.gc();
        System.out.println("JVM的空闲内存：" + runTime.freeMemory());

        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        long sum = 0;
        for (long i = 0; i < 10000000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println("开始结束时间相差" + (endTime - startTime) + "毫秒");

        Date curDate = new Date(System.currentTimeMillis()); //获取当前时间
        System.out.println(curDate);
        Calendar aCalendar = Calendar.getInstance();//新建日历对象
        aCalendar.setTime(curDate);//设置当前时间为日历中的时间
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);//获取当前时间在一年中的第几天
        System.out.println(day1);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date(System.currentTimeMillis());//获取当前时间
        String time = formatter.format(currentDate);
        System.out.println(time);

        Date date;
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        try {
            date = formater.parse(time);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String timeStr = "2015-3-1 16:20:00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     //format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));// 中国北京时间，东八区
        Date dateTime = null;
        try {
            dateTime = format.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateTime);

        Timestamp timestamp = new Timestamp(dateTime.getTime());
        System.out.println(timestamp);


        Timestamp ts = new Timestamp(System.currentTimeMillis());
        String tsStr = "2011-05-09 11:49:45";
        try {
            ts = Timestamp.valueOf(tsStr);
            System.out.println(ts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
