/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Stefan
 */

@Controller
public class CompanyController {
    private CompanyService companyService;
    
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String phoneNumber;
    
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    
    @RequestMapping("/company")
    String company(Model model) {
        name = companyService.getCompany().getName();
        model.addAttribute("name", name);
        
        address = companyService.getCompany().getAddress();
        model.addAttribute("address", address);
        
        postalCode = companyService.getCompany().getPostalCode();
        model.addAttribute("postalCode", postalCode);
        
        city = companyService.getCompany().getCity();
        model.addAttribute("city", city);
        
        country = companyService.getCompany().getCountry();
        model.addAttribute("country", country);
        
        phoneNumber = companyService.getCompany().getPhoneNumber();
        model.addAttribute("phoneNumber", phoneNumber);
        
        return "company";
    }
   
    @RequestMapping(value="/editcompany")
    String editcompany(Model model) {
        name = companyService.getCompany().getName();
        model.addAttribute("name", name);
        
        address = companyService.getCompany().getAddress();
        model.addAttribute("address", address);
        
        postalCode = companyService.getCompany().getPostalCode();
        model.addAttribute("postalCode", postalCode);
        
        city = companyService.getCompany().getCity();
        model.addAttribute("city", city);
        
        country = companyService.getCompany().getCountry();
        model.addAttribute("country", country);
        
        phoneNumber = companyService.getCompany().getPhoneNumber();
        model.addAttribute("phoneNumber", phoneNumber);
        
        return "editcompany";
    }
    
    @RequestMapping(value = "/editcompany", method = RequestMethod.POST)
    @ResponseBody
    public String companySubmit(
            @RequestParam(value = "name") String nameEdit,
            @RequestParam(value = "address") String addressEdit,
            @RequestParam(value = "postalCode") String postalCodeEdit,
            @RequestParam(value = "city") String cityEdit,
            @RequestParam(value = "country") String countryEdit,
            @RequestParam(value = "phoneNumber") String phoneNumberEdit
    ) {
        companyService.editCompany(nameEdit, addressEdit, postalCodeEdit, cityEdit, countryEdit, phoneNumberEdit);
        return "<a href='/company'>Keer terug</a>";
    }
}