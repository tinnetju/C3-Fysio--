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
    private int contractID;
    private int bSN;
    private int insuranceID;
    private int insuranceTypeID;
    private Date startDate;
    private Date endDate;
    private double excess;
    
    public InsuranceContract() {

    }
    
    public InsuranceContract(int contractID, int bSN, int insuranceID, int insuranceTypeID, Date startDate, Date endDate, double excess){
        this.contractID = contractID;
        this.bSN = bSN;
        this.insuranceID = insuranceID;
        this.insuranceTypeID = insuranceTypeID;
        this.contractID = contractID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.excess = excess;
    }
    
    //getters
    public int getContractID() {
        return contractID;
    }

    public int getBSN() {
        return bSN;
    }

    public int getInsuranceID() {
        return insuranceID;
    }

    public int getInsuranceTypeID() {
        return insuranceTypeID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getExcess() {
        return excess;
    }
    
    //setters
    public void setContractID(int contractID) {
        this.contractID = contractID;
    }

    public void setBSN(int bSN) {
        this.bSN = bSN;
    }

    public void setInsuranceID(int insuranceID) {
        this.insuranceID = insuranceID;
    }

    public void setInsuranceTypeID(int insuranceTypeID) {
        this.insuranceTypeID = insuranceTypeID;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setExcess(double excess) {
        this.excess = excess;
    }
}
