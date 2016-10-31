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
    private String city;
    private String postalCode;
    private String address;
    private int KVK;
    
    public Company(String name, String city, String postalCode, String address, int KVK){
        this.name = name;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.KVK = KVK;
    }
    
    //getters
    public String getName() {
        return name;
    }
    
    public String getCity() {
        return city;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getKVK() {
        return KVK;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setKVK(int KVK) {
        this.KVK = KVK;
    }
}