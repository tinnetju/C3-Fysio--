package nl.avans.C3.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import nl.avans.C3.DataStorage.ClientRepository;

@SuppressWarnings("Duplicates")
@Profile("default")
@Configuration
@EnableTransactionManagement
public class PersistenceContext {
    protected static final String PROPERTY_NAME_DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    protected static final String PROPERTY_NAME_DATABASE_PASSWORD = "password";
    protected static final String PROPERTY_NAME_DATABASE_URL = "jdbc:mysql://localhost:3306/facturatie";
    protected static final String PROPERTY_NAME_DATABASE_USERNAME = "root";

    private static final String PROPERTY_PACKAGES_TO_SCAN = "nl.avans.C3.Config";

    @Resource
    private Environment environment;
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
        dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
        dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(PROPERTY_NAME_DATABASE_URL, PROPERTY_NAME_DATABASE_USERNAME, PROPERTY_NAME_DATABASE_PASSWORD);
            System.out.println("Success!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dataSource;
    }

    @Bean
    @Primary
    @Qualifier("PersistenceContext")
    public ClientRepository getClientRepository() {
        return new ClientRepository(this.dataSource());
    }
}
