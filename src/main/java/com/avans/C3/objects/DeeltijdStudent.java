package com.avans.C3.objects;

/**
 *
 * @author TinneS
 */

public class DeeltijdStudent extends Student {
    private String company;
    private String function;

    public DeeltijdStudent(Name name, Number studentID)
    {
        super(name, studentID);
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
