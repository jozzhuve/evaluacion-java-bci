package pe.bci.com.clients.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.bci.com.clients.api.model.ClientResponse;
import pe.bci.com.clients.config.AppProperties;
import pe.bci.com.clients.entity.ClientRecord;
import pe.bci.com.clients.exception.ClienteException;
import pe.bci.com.clients.repository.PhoneRepository;
import pe.bci.com.clients.api.model.ClientRequest;
import pe.bci.com.clients.entity.PhoneRecord;
import pe.bci.com.clients.repository.ClientRepository;
import pe.bci.com.clients.service.ClientService;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

  private ClientRepository clientRepository;
  private PhoneRepository phoneRepository;
  private AppProperties appProperties;

  @Override
  public ClientResponse createClient(ClientRequest client) {

    clientRepository.findClientRecordByEmail(client.getEmail())
        .ifPresent(user -> {
          throw new ClienteException("El correo ya existe");
        });

    if(!validatePasswordRegularExpression(client.getPassword())){
      throw new ClienteException("La contraseña debe contener numeros y letras mayusculas y minusculas solamente");
    }

    ClientRecord clientRecord = clientRepository.save(
        ClientRecord.builder()
            .id(UUID.randomUUID())
            .name(client.getName())
            .email(client.getEmail())
            .password(client.getPassword())
            .created(new Date())
            .isActive(true).build());

    client.getPhones().forEach(phoneRequest -> {
      phoneRepository.save(
          PhoneRecord.builder()
              .id(UUID.randomUUID())
              .idClient(clientRecord.getId())
              .number(phoneRequest.getNumber())
              .cityCode(phoneRequest.getCityCode())
              .countryCode(phoneRequest.getCountryCode())
              .build());
    });

    return buildResponse(clientRecord);
  }

  private ClientResponse buildResponse(ClientRecord clientRecord) {
    return ClientResponse.builder()
        .id(clientRecord.getId())
        .created(clientRecord.getCreated())
        .modified(clientRecord.getModified())
        .lastLogin(clientRecord.getLastLogin())
        .token(UUID.randomUUID())
        .isActive(clientRecord.getIsActive())
        .build();
  }

  private boolean validatePasswordRegularExpression(String password) {
    String regex = appProperties.getPasswordRegexPattern();
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    return matcher.matches();
  }


}



