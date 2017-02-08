/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import java.util.List;
import nl.avans.C3.DataStorage.InsuranceContractRepositoryIF;
import nl.avans.C3.Domain.InsuranceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stefan
 */
@Service
public class InsuranceContractService {
    private InsuranceContractRepositoryIF insuranceContractRepositoryIF;
    
    @Autowired
    public void setInsuranceContractRepository(InsuranceContractRepositoryIF insuranceContractRepositoryIF) {
        this.insuranceContractRepositoryIF = insuranceContractRepositoryIF;
    }
    
    public InsuranceContract getInsuranceContract(int bSN) {
        List<InsuranceContract> insuranceContractList = insuranceContractRepositoryIF.getInsuranceContract(bSN);
        
        InsuranceContract insuranceContract = insuranceContractList.get(0);
        
        return insuranceContract;
    }
    
    public void updateInsuranceContractExcess(double excess, int contractID){
        insuranceContractRepositoryIF.updateInsuranceContractExcess(excess, contractID);
    }
}
