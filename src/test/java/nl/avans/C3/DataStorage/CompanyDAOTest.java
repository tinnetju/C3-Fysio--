/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import nl.avans.C3.Domain.Company;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan
 */
public class CompanyDAOTest {
    private String name1 = "Fysiotherapiepraktijk Moker";
    private String address1 = "Straat 1";
    private String postalCode1 = "1234AB";
    private String city1 = "Breda";
    private String country1 = "Nederland";
    private String phoneNumber1 = "0761234567";
        
    private Company company = new Company(name1, address1, postalCode1, city1, country1, phoneNumber1);
    
    public CompanyDAOTest() {  
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getCompany method, of class CompanyDAO.
     */
    @Test
    public void testGetCompany() {
        System.out.println("getCompany");
        CompanyDAO instance = new CompanyDAO();
        String expResult = company.getName();
        String result = instance.getCompany().getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of editCompany method, of class CompanyDAO.
     */
    @Test
    public void testEditCompany() {
        System.out.println("editCompany");
        String name = "Fysiotherapiepraktijk C";
        String address = "Hogestraat 6";
        String postalCode = "3553ZZ";
        String city = "Eindhoven";
        String country = "Madagascar";
        String phoneNumber = "0687654321";
        CompanyDAO instance = new CompanyDAO();
        instance.editCompany(name, address, postalCode, city, country, phoneNumber);
        String result = instance.getCompany().getName();
        assertEquals(name, result);
    }
    
}
