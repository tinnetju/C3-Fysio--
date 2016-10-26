/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ClientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Deze constructor wordt aangeroepen vanuit de config/PersistenceContext class.
    public ClientRepository(DataSource dataSource) { this.jdbcTemplate = new JdbcTemplate(dataSource); }

    @Transactional(readOnly=true)
    public List<Client> findAll() {
        List<Client> result = jdbcTemplate.query("SELECT * FROM client", new ClientRowMapper());
        return result;
    }
    
    @Transactional(readOnly=true)
    public Client findClientById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM client WHERE BSN=?",
                new Object[]{id}, new ClientRowMapper());
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

        // Zet de auto increment waarde in de Member
        //int newClientId = holder.getKey().intValue();
        //client.setClientID(newClientId);
        return client;
    }

    public void deleteClientById(int id) {
        jdbcTemplate.update("DELETE FROM client WHERE BSN=?", new Object[]{id});
    }
}
