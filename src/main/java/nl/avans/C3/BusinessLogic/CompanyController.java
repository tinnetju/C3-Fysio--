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

import nl.avans.C3.DataStorage.CompanyDAO;
/**
 *
 * @author Stefan
 */

@Controller
public class CompanyController {
    CompanyDAO dao = new CompanyDAO();
    
    @RequestMapping("/company")
    String company(Model model) {
        String name = dao.getCompany().getName();
        model.addAttribute("name", name);
       
        String address = dao.getCompany().getAddress();
        model.addAttribute("address", address);
       
        String postalCode = dao.getCompany().getPostalCode();
        model.addAttribute("postalCode", postalCode);
       
        String city = dao.getCompany().getCity();
        model.addAttribute("city", city);
       
        String country = dao.getCompany().getCountry();
        model.addAttribute("country", country);
       
        int phoneNumber = dao.getCompany().getPhoneNumber();
        model.addAttribute("phoneNumber", phoneNumber);
       
        return "company";
    }
   
    @RequestMapping(value="/editcompany")
    String editcompany(Model model) {
        String name = dao.getCompany().getName();
        model.addAttribute("name", name);
       
        String address = dao.getCompany().getAddress();
        model.addAttribute("address", address);
       
        String postalCode = dao.getCompany().getPostalCode();
        model.addAttribute("postalCode", postalCode);
       
        String city = dao.getCompany().getCity();
        model.addAttribute("city", city);
       
        String country = dao.getCompany().getCountry();
        model.addAttribute("country", country);
       
        int phoneNumber = dao.getCompany().getPhoneNumber();
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
            @RequestParam(value = "phoneNumber") int phoneNumberEdit
    ) {
        dao.editCompany(nameEdit, addressEdit, postalCodeEdit, cityEdit, countryEdit, phoneNumberEdit);
        return "<a href='/company'>Keer terug</a>";
    }
}