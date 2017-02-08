/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import nl.avans.C3.Domain.InsuranceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stefan
 */
@Repository
public class InsuranceContractRepository implements InsuranceContractRepositoryIF{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public InsuranceContractRepository(DataSource dataSource){ 
        this.jdbcTemplate = new JdbcTemplate(dataSource); 
    }
    
    @Transactional(readOnly=true)
    public List<InsuranceContract> getInsuranceContract(int bSN) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.YEAR, 1);
        Date newDate = c.getTime();
        
        List<InsuranceContract> result = jdbcTemplate.query("SELECT * FROM insurancecontract WHERE BSN = " + bSN + " AND EndDate BETWEEN '" + dateFormat.format(currentDate) + "' AND '" + dateFormat.format(newDate) + "'", new InsuranceContractRowMapper());
        return result;
    }
    
    public void updateInsuranceContractExcess(double excess, int contractID) {
        jdbcTemplate.update("UPDATE insurancecontract SET Excess = ? WHERE ContractID = ?", new Object[] {excess, contractID});
    }
}
