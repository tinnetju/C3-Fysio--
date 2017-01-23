/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import nl.avans.C3.Domain.Company;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Stefan
 */
@Repository
public class CompanyRepository {
    private String name = "Zorgverzekering CZ";
    private String address = "Straat 1";
    private String postalCode = "1234AB";
    private String city = "Breda";
    private String country = "Nederland";
    private String phoneNumber = "0761234567";
        
    private Company company = new Company(name, address, postalCode, city, country, phoneNumber);
    
    public Company getCompany() {
        return company;
    }
    
    public void editCompany(String name, String address, String postalCode, String city, String country, String phoneNumber) {
        company.setName(name);
        company.setAddress(address);
        company.setPostalCode(postalCode);
        company.setCity(city);
        company.setCountry(country);
        company.setPhoneNumber(phoneNumber);
    }
}
