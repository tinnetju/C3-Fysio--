/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.Domain;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class CompanyTest {
    
    public CompanyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getName method, of class Company.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        String expResult = "Fysiotherapiepraktijk A";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class Company.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        String expResult = "Rotterdam";
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalCode method, of class Company.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        String expResult = "4532PK";
        String result = instance.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Company.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        String expResult = "Langeweg 7a";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCountry method, of class Company.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        String expResult = "Nederland";
        String result = instance.getCountry();
        assertEquals(expResult, result);
    }

    /**
     * Test of getKVK method, of class Company.
     */
    @Test
    public void testGetKVK() {
        System.out.println("getKVK");
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        int expResult = 22123412;
        int result = instance.getKVK();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Company.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Fysiotherapiepraktijk B";
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        instance.setName(name);
        String newName = instance.getName();
        assertEquals(name, newName);
    }

    /**
     * Test of setCity method, of class Company.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "Tilburg";
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        instance.setCity(city);
        String newCity = instance.getCity();
        assertEquals(city, newCity);
    }

    /**
     * Test of setPostalCode method, of class Company.
     */
    @Test
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "4532QQ";
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        instance.setPostalCode(postalCode);
        String newPostalCode = instance.getPostalCode();
        assertEquals(postalCode, newPostalCode);
    }

    /**
     * Test of setAddress method, of class Company.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "Langeweg 7b";
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        instance.setAddress(address);
        String newAddress = instance.getAddress();
        assertEquals(address, newAddress);
    }

    /**
     * Test of setCountry method, of class Company.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "Duitsland";
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        instance.setCountry(country);
        String newCountry = instance.getCountry();
        assertEquals(country, newCountry);
    }

    /**
     * Test of setKVK method, of class Company.
     */
    @Test
    public void testSetKVK() {
        System.out.println("setKVK");
        int kVK = 22123412;
        Company instance = new Company("Fysiotherapiepraktijk A", "Rotterdam", "4532PK", "Langeweg 7a", "Nederland", 22123412);
        instance.setKVK(kVK);
        int newKVK = instance.getKVK();
        assertEquals(kVK, newKVK);
    }
    
}
