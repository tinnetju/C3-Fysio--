/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import nl.avans.C3.Domain.Company;

/**
 *
 * @author Tinne
 */
public interface CompanyRepositoryIF {
    public Company getCompany();
            
    public void editCompany(String name, String address, String postalCode, String city, String country, String phoneNumber);
}
