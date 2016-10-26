/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.Domain;

import java.util.ArrayList;

/**
 *
 * @author Thom
 */
public class Client {
    private int BSN;
    private String lastName;
    private String firstName;
    private String city;
    private String postalcode;
    private String address;
    private String IBAN;
    private boolean incasso;
    private String email;
    private String tel;
    private ArrayList<InsuranceContract> contracts;
    private ArrayList<Invoice> invoices;
 
    public Client()
    {
        this.contracts = new ArrayList<>();
    }
    
    public Client(int BSN, String lastName, String firstName, String city, String postalcode, String address, String IBAN, boolean incasso, String email, String tel, InsuranceContract contract){
        this.BSN = BSN;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.postalcode = postalcode;
        this.address = address;
        this.IBAN = IBAN;
        this.incasso = incasso;
        this.email = email;
        this.tel = tel;
        this.contracts = new ArrayList<>();
        contracts.add(contract);
    }
 
    public int getBSN() {
        return BSN;
    }

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public boolean isIncasso() {
        return incasso;
    }

    public void setIncasso(boolean incasso) {
        this.incasso = incasso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public ArrayList<InsuranceContract> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<InsuranceContract> contracts) {
        this.contracts = contracts;
    }

    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }
 
 public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
}
