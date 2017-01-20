package nl.avans.C3.BusinessLogic;

/**
 *
 * @author Tinne
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.validation.Valid;
import nl.avans.C3.Domain.Client;
import nl.avans.C3.Domain.ClientNotFoundException;
import nl.avans.C3.Domain.Insurance;
import nl.avans.C3.Domain.SearchQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ClientController {
    private javax.swing.JTable tblClients;
    private ClientService clientService;
   
   
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String Index(ModelMap model, @ModelAttribute("searchQuery") String searchQuery) {
        List<Client> clients = clientService.findAllClients();
        
        model.addAttribute("clients", clients);
        InitializeSearchOptions(model);
        
        String henk = searchQuery;
        
        return "clients";
    }
    
    /*@RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        SearchQuery searchQuery = new SearchQuery();
        model.addAttribute("SearchQuery", searchQuery);
        InitializeSearchOptions(model);
        return "clients";
    }
 
    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public String submitForm(ModelMap model, @Valid SearchQuery SearchQuery, BindingResult result) {
        model.addAttribute("searchQuery", searchQuery);
        String returnVal = "successSearchQuery";
        if(result.hasErrors()) {
            InitializeSearchOptions(model);
            returnVal = "searchQuery";
        } else {
            model.addAttribute("searchQuery", searchQuery);
        }      
        return returnVal;
    }*/

    private void InitializeSearchOptions(ModelMap model)
    {
        ArrayList<String> searchOptions = new ArrayList<>();
        searchOptions.add("Voornaam");
        searchOptions.add("Achternaam");
        searchOptions.add("BSN");
        searchOptions.add("Woonplaats");
        searchOptions.add("E-mail adres");
    }
    
    @RequestMapping(value = "/client/viewclient/{BSN}", method = RequestMethod.GET)
    public String getClientByBSN(@PathVariable int BSN, ModelMap model) throws ClientNotFoundException {

        Client client = null;
        try {
            client = clientService.findClientByBSN(BSN);
        } catch(ClientNotFoundException ex){
            //logger.error(ex.getMessage());
        }
        
        List<Insurance> insurances = clientService.getInsurancesForClient(BSN);

        model.addAttribute("client", client);
        model.addAttribute("insurances", insurances);
        return "views/client/viewclient";
    }
    
    @RequestMapping(value = "/client/create", method = RequestMethod.GET)
    public String createClient(ModelMap model) {
        Client client = new Client();
        
        model.addAttribute("client", client);
        return "views/client/create";
    }
    
    @RequestMapping(value="/client/create", method = RequestMethod.POST)
    public String validateAndSaveClient(@Valid Client client, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "views/client/create";
        }
        
        Client newClient = clientService.create(client);
        if(newClient != null) {
            model.addAttribute("info", "Cliënt '" + newClient.getFirstName() + " " + newClient.getLastName() + "' is toegevoegd.");
        } else {
            model.addAttribute("info", "Cliënt kon niet gemaakt worden.");
        }
        
        model.addAttribute("clients", clientService.findAllClients());
        return "clients";
    }
    
    @RequestMapping(value = "/client/edit/{BSN}", method = RequestMethod.GET)
    public String editClient(@PathVariable int BSN, ModelMap model) {
        Client client = null;
        try {
            client = clientService.findClientByBSN(BSN);
        } catch(ClientNotFoundException ex){
            //logger.error(ex.getMessage());
        }
        
        model.addAttribute("client", client);
        return "views/client/edit";
    }
    
    @RequestMapping(value="/client/edit", method = RequestMethod.POST)
    public String validateAndEditClient(@Valid Client client, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "views/client/edit";
        }
        
        try {
            clientService.update(client);
            model.addAttribute("info", "Cliënt '" + client.getFirstName() + " " + client.getLastName() + "' is gewijzigd.");
        } catch(Exception e){
            model.addAttribute("info", "Cliënt kon niet worden gewijzigd");
        }
        
        model.addAttribute("clients", clientService.findAllClients());
        return "clients";
    }
    
    
    @RequestMapping(value = "/client/delete/{BSN}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable int BSN, ModelMap model) {
        Client client = null;
        try {
            client = clientService.findClientByBSN(BSN);
            clientService.delete(BSN);
            model.addAttribute("info", "Cliënt '" + client.getFirstName() + " " + client.getLastName() + "' is verwijderd.");
        } catch(Exception e){
             model.addAttribute("info", "Cliënt kon niet worden verwijderd.");
        }
        model.addAttribute("clients", clientService.findAllClients());
        return "clients";
    }
}

