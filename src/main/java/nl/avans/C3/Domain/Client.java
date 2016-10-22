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
    private int tel;
    private ArrayList<InsuranceContract> contracts;
    private ArrayList<Invoice> invoices;
 
 public Client(int BSN, String lastName, String firstName, String city, String postalcode, String address, String IBAN, boolean incasso, String email, int tel, InsuranceContract contract){
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
 
 public void addInvoice(Invoice invoice){
        invoices.add(invoice);
    }
}
