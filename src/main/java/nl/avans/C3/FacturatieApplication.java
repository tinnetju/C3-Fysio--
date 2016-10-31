package nl.avans.C3;

import nl.avans.C3.Config.ApplicationConfig;
import nl.avans.C3.Config.ApplicationContext;
import nl.avans.C3.Config.PersistenceContext;
import nl.avans.C3.Config.ProductionContext;
import nl.avans.C3.Config.SwaggerConfig;

//imports test code Stefan
import nl.avans.C3.DataStorage.CompanyDAO;
import nl.avans.C3.Domain.Company;
//einde imports test code Stefan

import javafx.application.Application;
import nl.avans.C3.BusinessLogic.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@EnableConfigurationProperties
@ComponentScan(basePackages = {"nl.avans.C3"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class FacturatieApplication {
    
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {  
        //ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        //ClientService service = appContext.getBean("clientService", ClientService.class);
             
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //System.out.println(service.findAllClients().get(0).getFirstName());
        
        
        //test code van Stefan //
        System.out.println("- STAMGEGEVENS -\n");
        
        CompanyDAO dao = new CompanyDAO();
        
        System.out.println("Bedrijfsnaam: " + dao.getCompany().getName());
        System.out.println("Plaats: " + dao.getCompany().getCity());
        System.out.println("Postcode: " + dao.getCompany().getPostalCode());
        System.out.println("Adres: " + dao.getCompany().getAddress());
        System.out.println("KVK nummer: " + dao.getCompany().getKVK());
        //einde test code van Stefan
        
        
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ApplicationConfig.class);
        ctx.register(ApplicationContext.class);
        ctx.register(PersistenceContext.class);
        ctx.register(ProductionContext.class);
        ctx.register(SwaggerConfig.class);

        SpringApplication.run(FacturatieApplication.class);
    }
}