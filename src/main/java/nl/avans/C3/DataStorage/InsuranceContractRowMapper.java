/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.C3.DataStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import nl.avans.C3.Domain.InsuranceContract;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Stefan
 */
public class InsuranceContractRowMapper implements RowMapper<InsuranceContract>{
    @Override
    public InsuranceContract mapRow(ResultSet rs, int rowNum) throws SQLException {
        InsuranceContract insuranceContract = new InsuranceContract();
        insuranceContract.setContractID(rs.getInt("ContractID"));
        insuranceContract.setBSN(rs.getInt("BSN"));
        insuranceContract.setInsuranceID(rs.getInt("InsuranceID"));
        insuranceContract.setInsuranceTypeID(rs.getInt("InsuranceTypeID"));
        insuranceContract.setStartDate(rs.getDate("StartDate"));
        insuranceContract.setEndDate(rs.getDate("EndDate"));
        insuranceContract.setExcess(rs.getDouble("Excess"));
        return insuranceContract;
    }
}
