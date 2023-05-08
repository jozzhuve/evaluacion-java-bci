package pe.bci.com.clients.api.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.bci.com.clients.api.model.ClientResponse;
import pe.bci.com.clients.api.model.ClientRequest;
import pe.bci.com.clients.service.ClientService;
import pe.bci.com.clients.util.JacksonUtils;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ClientController {

  private ClientService clientService;

  @PostMapping("/cliente")
  @ApiOperation(
      value = "Crea un cliente en la base de datos.",
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      response = ClientResponse.class,
      httpMethod = "POST",
      notes = "classpath:swagger/notes/create-client.md"
  )
  @ApiResponses({
      @ApiResponse(code = 202, message = "El cliete se creo manera exitosa")}
  )
  public ClientResponse create(@Valid @RequestBody ClientRequest client) {
    log.info("request: {} ", JacksonUtils.getObjectAsString(client));
    return clientService.createClient(client);
  }
}
