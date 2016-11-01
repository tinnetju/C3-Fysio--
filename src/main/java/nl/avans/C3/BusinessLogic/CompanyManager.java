/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import nl.avans.C3.DataStorage.CompanyDAO;
import nl.avans.C3.Domain.Company;

/**
 *
 * @author Stefan
 */
public class CompanyManager {
    private Company company;
    private CompanyDAO dao = new CompanyDAO();
    
    public CompanyManager() {
        
    }
    
    public Company getCompany() {
        company = dao.getCompany();
        
        return company;
    }
    
    public void editCompany(String name, String address, String postalCode, String city, String country, String phoneNumber) {
        dao.editCompany(name, address, postalCode, city, country, phoneNumber);
    }
}
