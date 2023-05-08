package pe.bci.com.clients.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import pe.bci.com.clients.BaseMockMvcTest;
import pe.bci.com.clients.api.model.ClientRequest;
import pe.bci.com.clients.api.model.ClientResponse;
import pe.bci.com.clients.service.ClientService;
import pe.bci.com.clients.util.WiremockUtil;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ClientControllerTest extends BaseMockMvcTest {

    public static final String URL_ENDPOINT_CREATE_CLIENT = "/api/v1/cliente";

    @MockBean
    private ClientService clientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createClient() throws Exception {
        Mockito.when(clientService.createClient(any(ClientRequest.class))).thenReturn(ClientResponse.builder().build());
        mvc.perform(post(URL_ENDPOINT_CREATE_CLIENT)
                .content(WiremockUtil.obtainResource("json/create_client.json"))
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

}
