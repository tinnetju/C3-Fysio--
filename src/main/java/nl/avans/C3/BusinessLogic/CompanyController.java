/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.avans.C3.BusinessLogic.CompanyManager;
/**
 *
 * @author Stefan
 */

@Controller
public class CompanyController {
    private CompanyManager manager = new CompanyManager();
    
    private String name;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String phoneNumber;
    
    @RequestMapping("/company")
    String company(Model model) {
        name = manager.getCompany().getName();
        model.addAttribute("name", name);
        
        address = manager.getCompany().getAddress();
        model.addAttribute("address", address);
        
        postalCode = manager.getCompany().getPostalCode();
        model.addAttribute("postalCode", postalCode);
        
        city = manager.getCompany().getCity();
        model.addAttribute("city", city);
        
        country = manager.getCompany().getCountry();
        model.addAttribute("country", country);
        
        phoneNumber = manager.getCompany().getPhoneNumber();
        model.addAttribute("phoneNumber", phoneNumber);
        
        return "company";
    }
   
    @RequestMapping(value="/editcompany")
    String editcompany(Model model) {
        name = manager.getCompany().getName();
        model.addAttribute("name", name);
        
        address = manager.getCompany().getAddress();
        model.addAttribute("address", address);
        
        postalCode = manager.getCompany().getPostalCode();
        model.addAttribute("postalCode", postalCode);
        
        city = manager.getCompany().getCity();
        model.addAttribute("city", city);
        
        country = manager.getCompany().getCountry();
        model.addAttribute("country", country);
        
        phoneNumber = manager.getCompany().getPhoneNumber();
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
        manager.editCompany(nameEdit, addressEdit, postalCodeEdit, cityEdit, countryEdit, phoneNumberEdit);
        return "<a href='/company'>Keer terug</a>";
    }
}