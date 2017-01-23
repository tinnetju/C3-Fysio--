/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import nl.avans.C3.DataStorage.CompanyRepository;
import nl.avans.C3.DataStorage.CompanyRepositoryIF;
import nl.avans.C3.Domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stefan
 */
@Service
public class CompanyService {
    private Company company;
    private CompanyRepository companyRepository;
   
    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    
    public Company getCompany() {
        company = companyRepository.getCompany();
        
        return company;
    }
    
    public void editCompany(String name, String address, String postalCode, String city, String country, String phoneNumber) {
        companyRepository.editCompany(name, address, postalCode, city, country, phoneNumber);
    }
}
