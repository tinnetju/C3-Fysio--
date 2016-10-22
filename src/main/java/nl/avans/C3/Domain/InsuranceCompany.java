/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.Domain;

import java.util.ArrayList;

/**
 *
 * @author Thom
 */
public class InsuranceCompany {
    private String name;
    private String city;
    private String postalCode;
    private String address;
    private int KVK;
    private ArrayList<Insurance> insurances;
    
    public InsuranceCompany(String name, String city, String postalCode, String address, int KVK){
        this.name = name;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.KVK = KVK;
    }
}
