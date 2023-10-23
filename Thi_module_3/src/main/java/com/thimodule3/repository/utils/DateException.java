package com.thimodule3.repository.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateException {
    public static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
    public static SimpleDateFormat simpleDateFormatDay=new SimpleDateFormat("dd");
    public static SimpleDateFormat simpleDateFormatMonth=new SimpleDateFormat("MM");
    public static SimpleDateFormat simpleDateFormatYear=new SimpleDateFormat("yyyy");

    public static boolean checkAge18(Date date)
    {
        try {
            int year= Integer.parseInt(simpleDateFormatYear.format(date));
            int month= Integer.parseInt(simpleDateFormatMonth.format(date));
            int day= Integer.parseInt(simpleDateFormatDay.format(date));
            Date date1=new Date();
            int year1= Integer.parseInt(simpleDateFormatYear.format(date1));
            int month1= Integer.parseInt(simpleDateFormatMonth.format(date1));
            int day1= Integer.parseInt(simpleDateFormatDay.format(date1));
            if(year1-year>18) return true;
            if(year1-year<18) return false;
            if(month1>month) return true;
            if(month1<month) return false;
            if(day1>=day) return true;

        }catch (Exception e)
        {
            return false;
        }

        return false;
    }


    public static boolean checkAge100(Date date)
    {
        try {
            int year= Integer.parseInt(simpleDateFormatYear.format(date));
            int month= Integer.parseInt(simpleDateFormatMonth.format(date));
            int day= Integer.parseInt(simpleDateFormatDay.format(date));
            Date date1=new Date();
            int year1= Integer.parseInt(simpleDateFormatYear.format(date1));
            int month1= Integer.parseInt(simpleDateFormatMonth.format(date1));
            int day1= Integer.parseInt(simpleDateFormatDay.format(date1));

            if(year1-year>100) return true;
            if(year1-year<100) return false;
            if(month1>month) return true;
            if(month1<month) return false;
            if(day1>=day) return true;
        }
        catch (Exception e)
        {
            return false;
        }

        return false;
    }

    public static boolean compare(Date dateFirst,Date dateEnd)
    {
        int yearFirst= Integer.parseInt(simpleDateFormatYear.format(dateFirst));
        int monthFirst= Integer.parseInt(simpleDateFormatMonth.format(dateFirst));
        int dayFirst= Integer.parseInt(simpleDateFormatDay.format(dateFirst));

        int yearEnd= Integer.parseInt(simpleDateFormatYear.format(dateEnd));
        int monthEnd= Integer.parseInt(simpleDateFormatMonth.format(dateEnd));
        int dayEnd= Integer.parseInt(simpleDateFormatDay.format(dateEnd));
        if(yearEnd>yearFirst) return true;
        if(yearEnd<yearFirst) return false;
        if(monthEnd>monthFirst) return true;
        if(monthEnd<monthFirst) return false;
        if(dayEnd>dayFirst) return true;
        return false;
    }

}
