/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.Domain;

import java.util.Date;

/**
 *
 * @author Thom
 */
public class InsuranceContract {
    private double ownRisk;
    private String clientName;
    private int insuranceID;
    private Date startDate;
    private Date endDate;
    private Insurance insuranceType;
    private Client client;
    
    public InsuranceContract(double ownRisk, String clientName, int insuranceID, Date startDate, Date endDate, Insurance insuranceType, Client client){
        this.ownRisk = ownRisk;
        this.clientName = clientName;
        this.insuranceID = insuranceID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.insuranceType = insuranceType;
        this.client = client;
    }
}
