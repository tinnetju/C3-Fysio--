package nl.avans.C3.BusinessLogic;

/**
 *
 * @author Tinne
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nl.avans.C3.DataStorage.ClientRepository;
import nl.avans.C3.DataStorage.ClientRepositoryIF;
import nl.avans.C3.Domain.Client;
import nl.avans.C3.Domain.ClientNotFoundException;
import nl.avans.C3.Domain.Insurance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;


@Service
public class ClientService {
    private ClientRepositoryIF clientRepository;
    //private InsuranceService insuranceService;
    
    /*@Autowired
    public void setInsuranceService(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }*/
   
    @Autowired
    public void setClientRepositoryIF(ClientRepositoryIF clientRepositoryIF) {
        this.clientRepository = clientRepositoryIF;
    }
    
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }
    
    public Client findClientByBSN(int BSN) throws ClientNotFoundException {
        Client client = null;

        client = clientRepository.findClientByBSN(BSN);
        if(client.equals(null)) {
            throw new ClientNotFoundException("Exception!");
        } else {
            return client;
        }
    }
    
    public List<Insurance> getInsurancesForClient(int BSN) throws ClientNotFoundException
    {
        Client client = null;
        List<Insurance> insurances = null; //set in else 
        
        
        client = clientRepository.findClientByBSN(BSN);
        if(client.equals(null)) {
            throw new ClientNotFoundException("Exception!");
        } else {
            return insurances;
        }
    }
}
