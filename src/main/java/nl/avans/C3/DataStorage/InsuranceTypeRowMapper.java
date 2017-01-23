package nl.avans.C3.DataStorage;

import java.math.BigDecimal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import nl.avans.C3.Domain.Insurance;
import nl.avans.C3.Domain.InsuranceType;

/**
 *
 * @author Tinne
 */
public class InsuranceTypeRowMapper implements RowMapper<InsuranceType>
{
    @Override
    public InsuranceType mapRow(ResultSet rs, int rowNum) throws SQLException {
        InsuranceType insuranceType = new InsuranceType();
       
        insuranceType.setID(rs.getInt("InsuranceTypeID"));
        insuranceType.setName(rs.getString("InsuranceTypeName"));
        insuranceType.setDescription(rs.getString("InsuranceTypeDescription"));
        insuranceType.setReimbursementDescription(rs.getString("ReimbursementDescription"));        
        insuranceType.setReimbursementAmount(rs.getInt("ReimbursementAmount"));        
        return insuranceType;
    }
}
