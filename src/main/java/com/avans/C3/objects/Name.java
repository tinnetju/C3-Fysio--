package com.avans.C3.objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Name {
    String name;
    Pattern regexStr = Pattern.compile("[a-zA-Z]+");
    
    public Name(String name) {
    Matcher m = regexStr.matcher(name);
    if (m.find())
        {
            this.name = name;
        }
        else
        {
            System.out.println("Name failed the REGEX test");
        }
    }
    
    @Override
    public String toString(){
        return name;
    }
}
