/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import nl.avans.C3.Domain.Client;
import nl.avans.C3.Domain.ClientNotFoundException;
import nl.avans.C3.Domain.SearchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Stefan
 */

@Controller
public class InvoiceController {
    private ClientService clientService;
    
    @Autowired
    public InvoiceController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @RequestMapping("/invoice")
    public String Index(ModelMap model) {
        List<Client> clients = clientService.findAllClients();
        
        InitializeSearchOptions(model);
        SearchQuery searchquery = new SearchQuery();
        
        model.addAttribute("clients", clients);
        model.addAttribute("searchquery", searchquery);
        
        return "invoice";
    }
    
    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    public String Index(@Valid SearchQuery searchquery, final BindingResult bindingResult, final ModelMap model) {
        List<Client> clients = new ArrayList<Client>();
        
        InitializeSearchOptions(model);
        
        if(searchquery.getSearchWords().length() > 0)
        {
            try {
                switch (searchquery.getSearchOption()) {
                    case "BSN":
                        clients = clientService.findClientByBSN(searchquery.getSearchWords());
                        break;
                    case "Voornaam":
                        clients = clientService.findClientsByFirstName(searchquery.getSearchWords());
                        break;
                    case "Achternaam":
                        clients = clientService.findClientsByLastname(searchquery.getSearchWords());
                        break;
                }
            } catch(ClientNotFoundException ex){
                //logger.error(ex.getMessage());
            }
        }
        
        model.addAttribute("clients", clients);
        model.addAttribute("searchquery", searchquery);
        return "invoice";
    }

    private void InitializeSearchOptions(ModelMap model){
        ArrayList<String> searchOptions = new ArrayList<>();
        searchOptions.add("BSN");
        searchOptions.add("Voornaam");
        searchOptions.add("Achternaam");
        
        model.addAttribute("searchOptions", searchOptions);
    }
    
    @RequestMapping(value = "/clientinvoice/{BSN}", method = RequestMethod.GET)
    public String getClientByBSN(@PathVariable int BSN, ModelMap model) throws ClientNotFoundException {
        Client client = clientService.findClientByBSN(BSN);
        String firstName = client.getFirstName();
        String lastName = client.getLastName();
        
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        
        return "clientinvoice";
    }
}
