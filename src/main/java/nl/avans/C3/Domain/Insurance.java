/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.Domain;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Thom
 */
public class Insurance {
    private int ID;
    private String name;
    private BigDecimal price;
    private int sessionsReimbursed;
    private InsuranceCompany insuranceCompany;
    
    public Insurance(int ID, String name, BigDecimal price, int sessionsReimbursed){
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.sessionsReimbursed = sessionsReimbursed;
    }
}
