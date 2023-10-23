package com.thimodule3.repository.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesCheck {
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String DATE_REGEX="^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$";
    private static final String ID_REGEX="\\d{4}";
    private static final String ONE_REGEX="\\d{1}";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean checkDate(String text)
    {
        pattern = Pattern.compile(DATE_REGEX);
        matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static boolean checkId(String id)
    {
        if(id.charAt(0)=='0') return false;
        pattern = Pattern.compile(ID_REGEX);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }


    public static boolean checkOneNumber(String id)
    {
        pattern = Pattern.compile(ONE_REGEX);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public  static boolean checkEmail(String email)
    {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
