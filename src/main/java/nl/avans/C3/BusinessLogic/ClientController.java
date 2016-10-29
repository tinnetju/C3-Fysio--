package nl.avans.C3.BusinessLogic;

/**
 *
 * @author Tinne
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nl.avans.C3.Domain.Client;
import nl.avans.C3.Domain.ClientNotFoundException;
import nl.avans.C3.Domain.Insurance;
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
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ClientController {
    private javax.swing.JTable tblClients;
    private ClientService clientService;
    
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    
    
    @RequestMapping("/rits")
    public String hello(Model model) {
        model.addAttribute("message", "Hello from the controller");
        
        return "clients";
    }
    
    @RequestMapping(value = "/viewclient/{BSN}", method = RequestMethod.GET)
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
    
    @RequestMapping(value = "/addclient", method = RequestMethod.GET)
    public String addClient(ModelMap model) {
        Client client = new Client();
        
        model.addAttribute("client", client);
        model.addAttribute("message", new String("New client has been added successfully")); //CHECK VOOR MAKEN
        // Open de juiste view template als resultaat.
        return "views/client/home";
    }
    
    
    public void refreshTable(){
        DefaultTableModel clientTableModel = new DefaultTableModel();
        tblClients.setModel(clientTableModel);
        clientTableModel.addColumn("Ingrediëntnaam"); 
        clientTableModel.addColumn("Hoeveelheid");
        
        tblClients.getColumnModel().getColumn(1).setMinWidth(100);
        tblClients.getColumnModel().getColumn(1).setMaxWidth(100);
        
        List<Client> clientList = clientService.findAllClients();
        
        if(clientList.size() > 0){
            for (Client currentClient : clientList) {
                clientTableModel.addRow(new Object[]{"Naam", "Beschrijving", "Prijs", "Eigen risico"});
            }
        }
        else
            clientTableModel.addRow(new Object[]{"Geen ingrediënten gevonden"});
    }
}
