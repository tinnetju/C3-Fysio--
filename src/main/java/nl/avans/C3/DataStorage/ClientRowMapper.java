package nl.avans.C3.DataStorage;

import nl.avans.C3.Domain.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tinne
 */
public class ClientRowMapper implements RowMapper<Client>
{
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setBSN(rs.getInt("BSN"));
        client.setFirstName(rs.getString("FirstName"));
        client.setLastName(rs.getString("LastName"));
        client.setCity(rs.getString("City"));
        client.setPostalcode(rs.getString("PostalCode"));
        client.setAddress(rs.getString("Address"));
        client.setIBAN(rs.getString("IBAN"));
        client.setIncasso(rs.getBoolean("Incasso"));
        client.setEmail(rs.getString("EmailAddress"));
        client.setTel(rs.getString("PhoneNumber"));
        return client;
    }
}
