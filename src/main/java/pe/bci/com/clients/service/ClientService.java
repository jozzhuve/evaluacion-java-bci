package pe.bci.com.clients.service;

import pe.bci.com.clients.api.model.ClientResponse;
import pe.bci.com.clients.api.model.ClientRequest;

public interface ClientService {

    ClientResponse createClient(ClientRequest client);

}
