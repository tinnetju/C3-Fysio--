package nl.avans.C3.BusinessLogic;

/**
 *
 * @author Tinne
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import nl.avans.C3.DataStorage.ClientRepository;
import nl.avans.C3.Domain.Client;
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

public class ClientService {
    private ClientRepository clientRepository;
    
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
