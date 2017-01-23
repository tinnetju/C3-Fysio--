package nl.avans.C3.BusinessLogic;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import nl.avans.C3.Config.ApplicationContext;
import nl.avans.C3.Domain.Client;
import nl.avans.C3.Domain.ClientNotFoundException;
import nl.avans.C3.Domain.InsuranceContract;
import nl.avans.C3.Domain.Invoice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.test.context.TestContext;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

/**
 *
 */
@SuppressWarnings("Duplicates")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, ApplicationContext.class})
@WebAppConfiguration
public class ClientControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(ClientControllerTest.class);

    @Autowired
    WebApplicationContext context;

    WebClient webClient;

    @MockBean
    private ClientService clientService;

    final private int CLIENT_BSN = 58588;

    @Before
    public void setup() {
        logger.info("---- setUp ----");

        MockitoAnnotations.initMocks(this);

        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(context)
                .contextPath("")
                .build();
    }

    @After
    public void tearDown() {
        logger.info("---- tearDown ----");
        this.webClient.close();
    }

    @Test
    public void testFindClientByBSN_SuccessfullyFindsClient() throws ClientNotFoundException, IOException {
        logger.info("---- testFindBookById_SuccessfullyFindsBook ----");


        Client client = new Client(CLIENT_BSN, "de Vries", "Martijn", "Groningen", "2793AL", "Vrieslaand 48", "NL47 INGB 2929 1772 16", true, "mDeVries@hotmail.com", "0416-392837", null, null);
        try {
            when(clientService.findClientByBSN(anyInt())).thenReturn(client);
        } catch (ClientNotFoundException ex){
            logger.error(ex.getMessage());
        }

        HtmlPage bookPage = webClient.getPage("http://localhost:8080/client/viewclient/" + CLIENT_BSN);

        assertThat(bookPage.getUrl().toString()).endsWith("/viewclient/" + CLIENT_BSN);
        assertThat(bookPage.getTitleText()).isEqualTo("Avans Bieb");
    }

}