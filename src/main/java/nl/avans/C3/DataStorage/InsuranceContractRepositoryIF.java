/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import java.util.List;
import nl.avans.C3.Domain.InsuranceContract;

/**
 *
 * @author Stefan
 */
public interface InsuranceContractRepositoryIF {
    public List<InsuranceContract> getInsuranceContract(int bSN);
            
    public void updateInsuranceContractExcess(double excess, int contractID);
}
