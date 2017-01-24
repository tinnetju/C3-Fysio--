/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import nl.avans.C3.DataStorage.TreatmentRepositoryIF;
import nl.avans.C3.Domain.Treatment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stefan
 */
@Service
public class InvoiceService {
    private TreatmentRepositoryIF treatmentRepositoryIF;
    
    @Autowired
    public void setTreatmentRepository(TreatmentRepositoryIF treatmentRepositoryIF) {
        this.treatmentRepositoryIF = treatmentRepositoryIF;
    }
    
    public Treatment getTreatment(int behandelCode) {
        return treatmentRepositoryIF.getTreatment(behandelCode);
    }
}
