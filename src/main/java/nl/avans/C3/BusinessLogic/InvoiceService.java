/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.BusinessLogic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    
    public List<Treatment> getTreatments(int[] behandelCode) {
        List<Treatment> treatments = new LinkedList<Treatment>();
        
        for(int i = 0; i < behandelCode.length; i++) {
            treatments.add(treatmentRepositoryIF.getTreatment(behandelCode[i]));
        }
        
        return treatments;
    }
}
