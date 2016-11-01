/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.Domain;

/**
 *
 * @author Stefan
 */
public class Company {
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String phoneNumber;
    
    public Company(String name, String address, String postalCode, String city, String country, String phoneNumber){
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }
    
    //getters
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}