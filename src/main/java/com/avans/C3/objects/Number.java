package com.avans.C3.objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author TinneS
 */

public class Number {
    int number;
    Pattern regexStr = Pattern.compile("[0-9]+");
    
    public Number (int number)
    {
        Matcher m = regexStr.matcher(Integer.toString(number));
        if (m.find())
        {
            this.number = number;
        }
        else
        {
            System.out.println("Number failed the REGEX test");
        }
    }
}