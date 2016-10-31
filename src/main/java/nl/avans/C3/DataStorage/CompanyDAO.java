/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import nl.avans.C3.Domain.Company;

/**
 *
 * @author Stefan
 */
public class CompanyDAO {
    public Company getCompany() {

        String name = "Fysiotherapiepraktijk";
        String city = "Breda";
        String postalCode = "1234AB";
        String address = "Straat 1";
        int KVK = 12341234;
        
        Company company = new Company(name, city, postalCode, address, KVK);
        
        return company;
    }
}
