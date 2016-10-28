package nl.avans.C3.DataStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import nl.avans.C3.Domain.Client;

/**
 *
 * @author Tinne
 */
@Repository
public class ClientRepository implements ClientRepositoryIF {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    @Transactional(readOnly=true)
    public List<Client> findAll() {
        List<Client> result = jdbcTemplate.query("SELECT * FROM client", new ClientRowMapper());
        return result;
    }
    
    @Transactional(readOnly=true)
    public Client findClientByBSN(int BSN) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM client WHERE BSN=?",
                new Object[]{BSN}, new ClientRowMapper());
    }

    public Client create(final Client client) {
        final String sql = "INSERT INTO client('BSN', 'FirstName', 'LastName', 'City', 'PostalCode', 'Address', 'IBAN', 'Incasso', 'EmailAddress', 'TelephoneNumber') " +
                "VALUES(?,?,?,?,?,?,?,?,?,?)";

        // KeyHolder gaat de auto increment key uit de database bevatten.
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, client.getBSN());
                ps.setString(2, client.getFirstName());
                ps.setString(4, client.getLastName());
                ps.setString(3, client.getCity());
                ps.setString(5, client.getPostalcode());
                ps.setString(6, client.getAddress());
                ps.setString(7, client.getIBAN());
                ps.setBoolean(8, client.isIncasso());
                ps.setString(9, client.getEmail());
                ps.setString(10, client.getTel());
                return ps;
            }
        }, holder);

        return client;
    }

    public void deleteClientByBSN(int BSN) {
        jdbcTemplate.update("DELETE FROM client WHERE BSN=?", new Object[]{BSN});
    }
}
