package com.example.demouserservice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author guser
 * @Date 2022/11/24
 */
public class DateUtil {
    public static Date generationDateTime() {
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        Date dateTime = null;
        try {
            dateTime = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTime;
    }
}
